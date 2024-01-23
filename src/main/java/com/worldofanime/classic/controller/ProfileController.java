package com.worldofanime.classic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.worldofanime.classic.repository.UsersRepository;
import com.worldofanime.classic.repository.UserProfileRepository;
import com.worldofanime.classic.model.api.UserProfileRequest;
import com.worldofanime.classic.model.api.LoggedInUserProfileRequest;
import com.worldofanime.classic.model.api.UserProfileSingleRequest;
import com.worldofanime.classic.model.api.UserBlogRequest;
import com.worldofanime.classic.model.api.UserBlogCommentsRequest;
import com.worldofanime.classic.model.api.UserGalleryRequest;
import com.worldofanime.classic.model.api.Blog;
import com.worldofanime.classic.model.api.Gallery;
import com.worldofanime.classic.model.api.UserInfoRequest;
import com.worldofanime.classic.model.api.UserGroupsRequest;
import com.worldofanime.classic.model.api.UserNotificationsRequest;
import com.worldofanime.classic.model.api.UserNotificationsBody;
import com.worldofanime.classic.model.api.UserActivityFeedsRequest;
import com.worldofanime.classic.model.api.UserActivityFeedsData;
import com.worldofanime.classic.model.api.UserActivityFeedCommentsRequest;
import com.worldofanime.classic.model.api.ActivityFeedComment;
import com.worldofanime.classic.model.api.ActivityFeed;
import org.springframework.web.servlet.view.RedirectView;
import com.worldofanime.classic.service.ProfileService;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.ArrayList;

@Controller
public class ProfileController {

	@Value("${local.api.path}")
  	private String localApiPath;

    @Value("${blog.embed.tip}")
    private String blogEmbedTip;

    @Autowired
    ProfileService profileService; 

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);        

	@GetMapping("/profile/{name}")
	public String userProfile(@PathVariable String name, Model model,
        @ModelAttribute("metaTitle") String defaultMetaTitle,
        @ModelAttribute("metaDescription") String defaultMetaDescription,
        @CookieValue(name = "oauth_token", required = false) String oauthToken, 
        @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {

		RestTemplate restTemplate = new RestTemplate();
        UserProfileRequest userProfileRequest = restTemplate.getForObject(localApiPath + "/api/profile/" + name, UserProfileRequest.class);

		com.worldofanime.classic.model.api.UserProfile profile = new com.worldofanime.classic.model.api.UserProfile();

        for (com.worldofanime.classic.model.api.UserProfile temp : userProfileRequest.getBody().getResponse()) {
			if (temp.getContentUrl().endsWith("/" + name)) {
				profile = temp;
				break;
			}
		}

        if (!profile.userExists()) {
            return "profile-none";
        }


        // Need to make sure there is a user created for this account
        profileService.ensureUserAccount(profile, null);

        UserInfoRequest userInfoRequest = restTemplate.getForObject(localApiPath + "/api/profile/user_information/" + profile.getUserId(), UserInfoRequest.class);        
        UserGroupsRequest userGroupsRequest = restTemplate.getForObject(localApiPath + "/api/groups/user/" + profile.getUserId(), UserGroupsRequest.class);

        List<ActivityFeed> userActivityFeeds = new ArrayList<>();
        UserActivityFeedsRequest userActivityFeedsRequest = restTemplate.getForObject(localApiPath + "/api/profile/activity_feeds/" + profile.getUserId(), UserActivityFeedsRequest.class);

        com.worldofanime.classic.model.Users user = usersRepository.findById(profile.getUserId()).orElse(new com.worldofanime.classic.model.Users());
        com.worldofanime.classic.model.UserProfile userProfile = userProfileRepository.findById(user.getUserProfileId()).orElse(new com.worldofanime.classic.model.UserProfile());

        if (userActivityFeedsRequest.getStatusCode() != null && userActivityFeedsRequest.getStatusCode().equals("200")) {
            for (UserActivityFeedsData feed : userActivityFeedsRequest.getBody().getData()) {

                if (feed.getFeed().getSubjectId() == profile.getUserId()) {
                     feed.getFeed().setPoster(profile);
                } else {
                     UserProfileSingleRequest userProfileSingle = profileService.getUserProfileByUserId(feed.getFeed().getSubjectId(), oauthToken, oauthSecret);
                     if (userProfileSingle.getStatusCode().equals("200")) {
                        feed.getFeed().setPoster(userProfileSingle.getBody().getProfile());
                    }
                }

                // These posts are the roots
                if (feed.getFeed().getType().equals("status") ) {

                    UserActivityFeedCommentsRequest userActivityFeedCommentsRequest = restTemplate.getForObject(localApiPath + "/api/profile/activity_feeds/comments/" + feed.getFeed().getActionId(), UserActivityFeedCommentsRequest.class);
                    try {
                        List<ActivityFeedComment> comments = userActivityFeedCommentsRequest.getBody().getComments();
                        feed.getFeed().setComments(comments);
                    } catch (Exception e) {
                    }
                    userActivityFeeds.add(feed.getFeed());
                }


                // These posts we need to get the root
            }
        }


        model.addAttribute("feeds", userActivityFeeds);

        model.addAttribute("profile", profile);
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("personalInformation", userInfoRequest.getBody().getPersonalInformation());
        model.addAttribute("contactInformation", userInfoRequest.getBody().getContactInformation());
        model.addAttribute("personalDetails", userInfoRequest.getBody().getPersonalDetails());
        model.addAttribute("groups", userGroupsRequest.getBody().getResponse());

        model.addAttribute("metaTitle", defaultMetaTitle + " - Profile Page for " + profile.getUsername());
        model.addAttribute("metaDescription", "This is the Profile Page for " + profile.getUsername() + " on World of Anime Classic.  Come make your own profile page and say hello!");

		return "profile";
	}


    @GetMapping("/profile/{name}/friends")
    public String userProfileFriends(@PathVariable String name, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        UserProfileRequest userProfileRequest = restTemplate.getForObject(localApiPath + "/api/profile/" + name, UserProfileRequest.class);

        com.worldofanime.classic.model.api.UserProfile profile = new com.worldofanime.classic.model.api.UserProfile();

        if (userProfileRequest.getBody().getResponse().size() == 1) {
            profile = userProfileRequest.getBody().getResponse().get(0);
        } else {
            for (com.worldofanime.classic.model.api.UserProfile temp : userProfileRequest.getBody().getResponse()) {
                if (temp.getContentUrl().endsWith("/" + name)) {
                    profile = temp;
                    break;
                }
            }
        }

        model.addAttribute("profile", profile);

        return "profile_friends";
    }


    @GetMapping("/profile/{name}/blog")
    public String userProfileBlogs(@PathVariable String name, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        UserProfileRequest userProfileRequest = restTemplate.getForObject(localApiPath + "/api/profile/" + name, UserProfileRequest.class);

        com.worldofanime.classic.model.api.UserProfile profile = new com.worldofanime.classic.model.api.UserProfile();

        if (userProfileRequest.getBody().getResponse().size() == 1) {
            profile = userProfileRequest.getBody().getResponse().get(0);
            List<Blog> blogs = profileService.getUserBlogs(profile.getUserId()).getBody().getBlogs();
            model.addAttribute("blogs", blogs);            
        } else {
            for (com.worldofanime.classic.model.api.UserProfile temp : userProfileRequest.getBody().getResponse()) {
                if (temp.getContentUrl().endsWith("/" + name)) {
                    profile = temp;
                    break;
                }
            }
        }

        model.addAttribute("profile", profile);
        model.addAttribute("embedTip", blogEmbedTip);

        return "profile_blog";
    }

    @GetMapping("/profile/{name}/blog/{blogId}")
    public String userProfileBlog(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret, @PathVariable String name, @PathVariable int blogId, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        UserProfileRequest userProfileRequest = restTemplate.getForObject(localApiPath + "/api/profile/" + name, UserProfileRequest.class);

        com.worldofanime.classic.model.api.UserProfile profile = new com.worldofanime.classic.model.api.UserProfile();

        if (userProfileRequest.getBody().getResponse().size() == 1) {
            profile = userProfileRequest.getBody().getResponse().get(0);

            UserBlogRequest blogRequest = profileService.getUserBlogByBlogId(blogId);
            model.addAttribute("blog", blogRequest.getBody().getResponse());

            UserBlogCommentsRequest blogCommentsRequest = profileService.getUserBlogCommentsByBlogId(blogId, oauthToken, oauthSecret);
            if (blogCommentsRequest.getStatusCode().equals("200")) {
                model.addAttribute("blogComments", blogCommentsRequest.getBody().getViewAllComments());
            }
        } else {
            for (com.worldofanime.classic.model.api.UserProfile temp : userProfileRequest.getBody().getResponse()) {
                if (temp.getContentUrl().endsWith("/" + name)) {
                    profile = temp;
                    break;
                }
            }
        }

        model.addAttribute("profile", profile);

        return "profile_blog_entry";
    }

    @GetMapping("/profile/{name}/gallery")
    public String userProfileGalleries(@PathVariable String name, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        UserProfileRequest userProfileRequest = restTemplate.getForObject(localApiPath + "/api/profile/" + name, UserProfileRequest.class);

        com.worldofanime.classic.model.api.UserProfile profile = new com.worldofanime.classic.model.api.UserProfile();

        if (userProfileRequest.getBody().getResponse().size() == 1) {
            profile = userProfileRequest.getBody().getResponse().get(0);
            try {
                List<Gallery> galleries = profileService.getUserGalleries(profile.getUserId()).getBody().getGalleries();
                model.addAttribute("galleries", galleries);
            } catch (Exception e) {
            }
        } else {
            for (com.worldofanime.classic.model.api.UserProfile temp : userProfileRequest.getBody().getResponse()) {
                if (temp.getContentUrl().endsWith("/" + name)) {
                    profile = temp;
                    break;
                }
            }
        }

        model.addAttribute("profile", profile);

        return "profile_galleries";
    }

    @GetMapping("/profile/{name}/gallery/{galleryId}")
    public String userProfileGalleries(@PathVariable String name, @PathVariable int galleryId, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        UserProfileRequest userProfileRequest = restTemplate.getForObject(localApiPath + "/api/profile/" + name, UserProfileRequest.class);

        com.worldofanime.classic.model.api.UserProfile profile = new com.worldofanime.classic.model.api.UserProfile();

        if (userProfileRequest.getBody().getResponse().size() == 1) {
            profile = userProfileRequest.getBody().getResponse().get(0);
            UserGalleryRequest galleryRequest = profileService.getUserGalleryByGalleryId(galleryId);
            model.addAttribute("gallery", galleryRequest.getBody());
        } else {
            for (com.worldofanime.classic.model.api.UserProfile temp : userProfileRequest.getBody().getResponse()) {
                if (temp.getContentUrl().endsWith("/" + name)) {
                    profile = temp;
                    break;
                }
            }
        }

        model.addAttribute("profile", profile);

        return "profile_gallery";
    }

    @GetMapping("/profile/{name}/groups")
    public String userProfileGroups(@PathVariable String name, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        UserProfileRequest userProfileRequest = restTemplate.getForObject(localApiPath + "/api/profile/" + name, UserProfileRequest.class);

        com.worldofanime.classic.model.api.UserProfile profile = new com.worldofanime.classic.model.api.UserProfile();

        if (userProfileRequest.getBody().getResponse().size() == 1) {
            profile = userProfileRequest.getBody().getResponse().get(0);
        } else {
            for (com.worldofanime.classic.model.api.UserProfile temp : userProfileRequest.getBody().getResponse()) {
                if (temp.getContentUrl().endsWith("/" + name)) {
                    profile = temp;
                    break;
                }
            }
        }

        UserGroupsRequest userGroupsRequest = restTemplate.getForObject(localApiPath + "/api/groups/user/" + profile.getUserId(), UserGroupsRequest.class);

        model.addAttribute("profile", profile);
        model.addAttribute("groups", userGroupsRequest.getBody().getResponse());        

        return "profile_groups";
    }

    @GetMapping("/profile/{name}/edit/main")
    public String userProfileEditMain(@PathVariable String name, Model model, @ModelAttribute("noticeHeader") String noticeHeader) {

        RestTemplate restTemplate = new RestTemplate();
        UserProfileRequest userProfileRequest = restTemplate.getForObject(localApiPath + "/api/profile/" + name, UserProfileRequest.class);

        com.worldofanime.classic.model.api.UserProfile profile = new com.worldofanime.classic.model.api.UserProfile();

        if (userProfileRequest.getBody().getResponse().size() == 1) {
            profile = userProfileRequest.getBody().getResponse().get(0);
        } else {
            for (com.worldofanime.classic.model.api.UserProfile temp : userProfileRequest.getBody().getResponse()) {
                if (temp.getContentUrl().endsWith("/" + name)) {
                    profile = temp;
                    break;
                }
            }
        }

        UserInfoRequest userInfoRequest = restTemplate.getForObject(localApiPath + "/api/profile/user_information/" + profile.getUserId(), UserInfoRequest.class);        


        model.addAttribute("profile", profile);
        model.addAttribute("personalInformation", userInfoRequest.getBody().getPersonalInformation());
        model.addAttribute("contactInformation", userInfoRequest.getBody().getContactInformation());
        model.addAttribute("personalDetails", userInfoRequest.getBody().getPersonalDetails());

        return "profile_edit_main";
    }

    @PostMapping("/update/profile/main")
        public RedirectView userProfileEditMain(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret, @RequestHeader("Referer") String referer, RedirectAttributes redirectAttrs) {
        RestTemplate restTemplate = new RestTemplate();
        LoggedInUserProfileRequest loggedInUserProfileRequest = profileService.getLoggedInUserProfile(oauthToken, oauthSecret);

        com.worldofanime.classic.model.api.UserProfile profile = new com.worldofanime.classic.model.api.UserProfile();

        profile = loggedInUserProfileRequest.getBody().getResponse();

//        UserInfoRequest userInfoRequest = restTemplate.getForObject(localApiPath + "/api/profile/user_information/" + profile.getUserId(), UserInfoRequest.class);        

        // model.addAttribute("profile", profile);
        // model.addAttribute("personalInformation", userInfoRequest.getBody().getPersonalInformation());
        // model.addAttribute("contactInformation", userInfoRequest.getBody().getContactInformation());
        // model.addAttribute("personalDetails", userInfoRequest.getBody().getPersonalDetails());

        redirectAttrs.addFlashAttribute("noticeHeader", "Your settings have been saved."); 

        logger.info("Referer " + referer);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(referer);
        return redirectView;
    }       


    @GetMapping("/notifications/check")
    @ResponseBody
    public String getNumNotificationsForLoggedInUser(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {

       if (!com.google.common.base.Strings.isNullOrEmpty(oauthToken)) {
          
          RestTemplate restTemplate = new RestTemplate();
          UserNotificationsRequest userNotificationsRequest = restTemplate.getForObject(localApiPath + "/api/profile/num-notifications?oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret, UserNotificationsRequest.class);

          if (userNotificationsRequest.getBody().getTotalNotifications() > 0) {
            return "(" + userNotificationsRequest.getBody().getTotalNotifications() + " New)";
          }
        }
        
        return "";
    }


}