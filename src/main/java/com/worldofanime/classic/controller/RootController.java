package com.worldofanime.classic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.worldofanime.classic.model.api.UserProfile;
import com.worldofanime.classic.model.api.UserProfileRequest;
import com.worldofanime.classic.model.api.UserProfileSingleRequest;
import com.worldofanime.classic.model.api.UserFriendRequestsRequest;
import com.worldofanime.classic.model.api.UserBlogsRequest;
import com.worldofanime.classic.model.api.Blog;
import com.worldofanime.classic.service.ProfileService;
import com.worldofanime.classic.service.ContactService;
import com.worldofanime.classic.service.BlogsService;
import org.springframework.web.client.RestTemplate;
import com.worldofanime.classic.model.DbTitles;
import com.worldofanime.classic.model.DbTitleReviews;
import com.worldofanime.classic.model.ArtStoryChapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import com.worldofanime.classic.model.Users;
import com.worldofanime.classic.repository.DbTitlesRepository;
import com.worldofanime.classic.repository.DbTitleReviewsRepository;
import com.worldofanime.classic.repository.ArtStoryChapterRepository;
import com.worldofanime.classic.repository.UsersRepository;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;


@Controller
public class RootController {

  	@Autowired
  	ProfileService profileService;

  	@Autowired
  	ContactService contactService;

  	@Autowired
  	BlogsService blogsService;	

	@Autowired
	DbTitlesRepository dbTitlesRepository;  	

	@Autowired
	DbTitleReviewsRepository dbTitleReviewsRepository;

	@Autowired
	ArtStoryChapterRepository artStoryChapterRepository;

	@Autowired
	UsersRepository usersRepository;

	@Value("${local.api.path}")
  	private String localApiPath;

    private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);   	  	

	@GetMapping("/")
	public String home(Model model) {

		DbTitles title = dbTitlesRepository.findRandomDbTitle(new PageRequest(0, 1)).getContent().get(0);
		model.addAttribute("randomAnimeTitle", title);

		DbTitleReviews review = dbTitleReviewsRepository.findFirstByOrderByIdDesc();
		model.addAttribute("review", review);

		Set<ArtStoryChapter> chapters = artStoryChapterRepository.findTop5ByOrderByIdDesc();
		model.addAttribute("chapters", chapters);

		return "home";
	}

	@GetMapping("/newsletter")
	public String newsletter() {
		return "newsletter";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/blogs")
	public String latestBlogs(Model model, @CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {

        UserBlogsRequest userBlogsRequest = blogsService.getLatestBlogs(10);

        model.addAttribute("blogs", userBlogsRequest.getBody().getBlogs());

        Map<Integer, UserProfileSingleRequest> map = new HashMap<Integer, UserProfileSingleRequest>();

		for (Blog temp : userBlogsRequest.getBody().getBlogs()) {
			if (!map.containsKey(temp.getOwnerId())) {
				UserProfileSingleRequest userProfileRequest = profileService.getUserProfileByUserId(temp.getOwnerId(), oauthToken, oauthSecret);
				map.put(temp.getOwnerId(), userProfileRequest);				
			}
		}

		model.addAttribute("users", map);
		return "latest_blogs";
	}

	@GetMapping("/gallery_images")
	public String latestGalleryImages(Model model) {

		return "latest_gallery_images";
	}

	@GetMapping("/chat")
	public String chat(Model model) {
		String onClick = "window.open(\"http://widget.mibbit.com/?server=irc.mibbit.com&channel=%23WorldOfAnime&settings=cd6f74ce3847d1ec56118035373ef5cc&nick=USERNAME\",\"\",\"width=999,height=555\")";

		model.addAttribute("onClick", onClick);
		return "chat";
	}

	@PostMapping("/contact")
	public String contacted(@RequestParam("Name") String name, @RequestParam("Email") String email, @RequestParam("Message") String message, Model model) {

		contactService.sendContactMessage(name, email, message);

		model.addAttribute("contacted", true);
        return "contact";
	}	

	@GetMapping("/online")
	public String whoIsOnline(Model model, @CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {

		RestTemplate restTemplate = new RestTemplate();
        UserProfileRequest userProfileRequest = restTemplate.getForObject(localApiPath + "/api/online_se", UserProfileRequest.class);

		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.MINUTE, -30);
		Date latestActivityDate = cal.getTime();

        List<Users> usersClassic = usersRepository.findByLatestActivityDateAfter(latestActivityDate);
        List<UserProfile> userProfilesClassic = new ArrayList<UserProfile>();

        for (Users user : usersClassic) {
        	UserProfileSingleRequest request = profileService.getUserProfileByUserId(user.getId(), oauthToken, oauthSecret);
        	if (request.getStatusCode().equals("200")) {
        		userProfilesClassic.add(request.getBody().getProfile());
        	}
        }

        model.addAttribute("usersSE", userProfileRequest.getBody().getResponse());
        model.addAttribute("usersClassic", userProfilesClassic);
		return "online";
	}

	@GetMapping("/friend_requests")
	public String friendRequests(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret, Model model) {

    	if (!com.google.common.base.Strings.isNullOrEmpty(oauthToken)) {

	     	UserFriendRequestsRequest userFriendRequestsRequest = profileService.getUserFriendRequestsLoggedInUserProfile(oauthToken, oauthSecret);

	     	model.addAttribute("friendRequests", userFriendRequestsRequest.getBody().getNotifications());
     	}

		return "friend_requests";
	}

}