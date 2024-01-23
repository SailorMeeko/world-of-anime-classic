package com.worldofanime.classic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.worldofanime.classic.model.api.UserProfileRequest;
import com.worldofanime.classic.model.api.UserProfileSingleRequest;
import com.worldofanime.classic.model.api.LoggedInUserProfileRequest;
import com.worldofanime.classic.model.api.UserInfoRequest;
import com.worldofanime.classic.model.api.UserFriendsRequest;
import com.worldofanime.classic.model.api.UserBlogsRequest;
import com.worldofanime.classic.model.api.UserBlogCommentsRequest;
import com.worldofanime.classic.model.api.UserBlogRequest;
import com.worldofanime.classic.model.api.UserGalleriesRequest;
import com.worldofanime.classic.model.api.UserGalleryRequest;
import com.worldofanime.classic.model.api.UserNotificationsRequest;
import com.worldofanime.classic.model.api.UserFriendRequestsRequest;
import com.worldofanime.classic.model.api.UserFriendRequestAcceptOrRejectRequest;
import com.worldofanime.classic.model.api.UserActivityFeedsRequest;
import com.worldofanime.classic.model.api.UserActivityFeedCommentsRequest;
import com.worldofanime.classic.model.api.Notification;
import com.worldofanime.classic.model.Users;
import com.worldofanime.classic.model.UserProfile;
import com.worldofanime.classic.repository.UsersRepository;
import com.worldofanime.classic.repository.UserProfileRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;

@Service
public class ProfileService {

	@Value("${rest.api.oauth_consumer_key}")
	private String oauthConsumerKey;

	@Value("${rest.api.oauth_consumer_secret}")
	private String oauthConsumerSecret;

    @Value("${rest.api.default_oauth_token}")
    private String oauthTokenDefault;

    @Value("${rest.api.default_oauth_secret}")
    private String oauthSecretDefault;

    @Autowired
    UsersRepository usersRepository;    

    @Autowired
    UserProfileRepository userProfileRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);        

    public UserProfileRequest getUserProfile(String username) {

    	RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        String url = "http://www.worldofanime.com/api/rest/members?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&displayname=" + username;
        //logger.info("Calling" + url);
        UserProfileRequest userProfileRequest = restTemplate.getForObject(url, UserProfileRequest.class);

        return userProfileRequest;
    }

    public UserProfileSingleRequest getUserProfileByUserId(int userId, String oauthToken, String oauthSecret) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        if (oauthToken == null) {
            oauthToken = oauthTokenDefault;
        }

        if (oauthSecret == null) {
            oauthSecret = oauthSecretDefault;
        }
        
        String url = "http://www.worldofanime.com/api/rest/user/profile/" + userId + "?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret;
        // logger.info("Calling " + url);
        UserProfileSingleRequest userProfileSingleRequest = restTemplate.getForObject(url, UserProfileSingleRequest.class);

        return userProfileSingleRequest;
    }    

    public UserProfileRequest getOnlineUsersSE() {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        UserProfileRequest userProfileRequest = restTemplate.getForObject("http://www.worldofanime.com/api/rest/members?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&is_online=1", UserProfileRequest.class);

        return userProfileRequest;
    }    

    public UserInfoRequest getUserInformation(int userId, String oauthToken, String oauthSecret) {

    	RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        if (oauthToken == null) {
            oauthToken = oauthTokenDefault;
        }

        if (oauthSecret == null) {
            oauthSecret = oauthSecretDefault;
        }

        String url = "http://www.worldofanime.com/api/rest/members/profile/get-member-info?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret + "&user_id=" + userId;
        // logger.info("Calling " + url);
        UserInfoRequest userInfoRequest = restTemplate.getForObject(url, UserInfoRequest.class);

        return userInfoRequest;

    }

    public LoggedInUserProfileRequest getLoggedInUserProfile(String oauthToken, String oauthSecret) {

    	RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        LoggedInUserProfileRequest loggedInUserProfileRequest = restTemplate.getForObject("http://www.worldofanime.com/api/rest/profile/get-member-info?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret, LoggedInUserProfileRequest.class);

        return loggedInUserProfileRequest;
    }

    public UserFriendsRequest getUserFriendsLoggedInUserProfile(String oauthToken, String oauthSecret) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        String url = "http://www.worldofanime.com/api/rest/user/get-friend-list?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret + "&limit=9999";
        // logger.info("Calling " + url);
        UserFriendsRequest userFriendsRequest = restTemplate.getForObject(url, UserFriendsRequest.class);

        return userFriendsRequest;
    }

    public UserFriendRequestsRequest getUserFriendRequestsLoggedInUserProfile(String oauthToken, String oauthSecret) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        UserFriendRequestsRequest userFriendRequestsRequest = restTemplate.getForObject("http://www.worldofanime.com/api/rest/notifications/friend-request?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret + "&limit=9999", UserFriendRequestsRequest.class);

        return userFriendRequestsRequest;
    }    

    public UserNotificationsRequest getUserNumNotifications(String oauthToken, String oauthSecret) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        UserNotificationsRequest userNotificationsRequest = restTemplate.getForObject("http://www.worldofanime.com/api/rest/notifications/new-updates?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret, UserNotificationsRequest.class);

        return userNotificationsRequest;
    }

    public UserFriendsRequest getUserFriends(int userId, String oauthToken, String oauthSecret) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        if (oauthToken == null) {
            oauthToken = oauthTokenDefault;
        }

        if (oauthSecret == null) {
            oauthSecret = oauthSecretDefault;
        }        

        String url = "http://www.worldofanime.com/api/rest/user/get-friend-list?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret + "&user_id=" + userId + "&limit=9999";
        // logger.info("Calling " + url);
        UserFriendsRequest userFriendsRequest = restTemplate.getForObject(url, UserFriendsRequest.class);

        return userFriendsRequest;
    }

    public UserFriendRequestAcceptOrRejectRequest acceptFriendRequest(String oauthToken, String oauthSecret, int userId) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("oauth_consumer_key", oauthConsumerKey);
        map.add("oauth_consumer_secret", oauthConsumerSecret);
        map.add("oauth_token", oauthToken);
        map.add("oauth_secret", oauthSecret);
        map.add("user_id", Integer.toString(userId));

        UserFriendRequestAcceptOrRejectRequest userFriendRequestAcceptRequest = restTemplate.postForObject("http://www.worldofanime.com/api/rest/user/confirm", map, UserFriendRequestAcceptOrRejectRequest.class);

        return userFriendRequestAcceptRequest;
    }    

    public UserFriendRequestAcceptOrRejectRequest rejectFriendRequest(String oauthToken, String oauthSecret, int userId) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("oauth_consumer_key", oauthConsumerKey);
        map.add("oauth_consumer_secret", oauthConsumerSecret);
        map.add("oauth_token", oauthToken);
        map.add("oauth_secret", oauthSecret);
        map.add("user_id", Integer.toString(userId));

        UserFriendRequestAcceptOrRejectRequest userFriendRequestRejectRequest = restTemplate.postForObject("http://www.worldofanime.com/api/rest/user/reject", map, UserFriendRequestAcceptOrRejectRequest.class);

        return userFriendRequestRejectRequest;
    }

    public UserActivityFeedsRequest getUserActivityFeeds(int userId) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        UserActivityFeedsRequest userActivityFeedsRequest = new UserActivityFeedsRequest();

        String url = "http://www.worldofanime.com/api/rest/advancedactivity/feeds?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&subject_id=" + userId + "&subject_type=user&filter_type=posts&object_info=1";

        try {
            userActivityFeedsRequest = restTemplate.getForObject(url, UserActivityFeedsRequest.class);
        } catch (Exception e) {
            // No activity feeds because data is returned as empty string and Jackson doesn't like it
        }

        return userActivityFeedsRequest;
    }

    public UserActivityFeedCommentsRequest getUserActivityFeedComments(int actionId) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        String url = "http://www.worldofanime.com/api/rest/activity/likes-comments?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&action_id=" + actionId + "&viewAllComments=1";
        UserActivityFeedCommentsRequest userActivityFeedCommentsRequest = restTemplate.getForObject(url, UserActivityFeedCommentsRequest.class);

        return userActivityFeedCommentsRequest;
    }    

    public UserBlogsRequest getUserBlogs(int userId) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        String url = "http://www.worldofanime.com/api/rest/blogs?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&user_id=" + userId;
        // logger.info("Calling " + url);
        UserBlogsRequest userBlogsRequest = restTemplate.getForObject(url, UserBlogsRequest.class);

        return userBlogsRequest;
    }

    public UserBlogRequest getUserBlogByBlogId(int blogId) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        UserBlogRequest userBlogRequest = restTemplate.getForObject("http://www.worldofanime.com/api/rest/blogs/view/" + blogId + "?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret, UserBlogRequest.class);

        return userBlogRequest;
    }

    public UserBlogCommentsRequest getUserBlogCommentsByBlogId(int blogId, String oauthToken, String oauthSecret) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        if (oauthToken == null) {
            oauthToken = oauthTokenDefault;
        }

        if (oauthSecret == null) {
            oauthSecret = oauthSecretDefault;
        }

        String url = "http://www.worldofanime.com/api/rest/likes-comments" + "?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret + "&subject_type=blog&subject_id=" + blogId + "&viewAllLikes=0&viewAllComments=1&page=1&limit=99999";
        UserBlogCommentsRequest userBlogCommentsRequest = restTemplate.getForObject(url, UserBlogCommentsRequest.class);

        // logger.info("Calling " + url);        

        return userBlogCommentsRequest;
    }            

    public UserGalleriesRequest getUserGalleries(int userId) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        UserGalleriesRequest userGalleriesRequest = restTemplate.getForObject("http://www.worldofanime.com/api/rest/albums?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&user_id=" + userId, UserGalleriesRequest.class);

        return userGalleriesRequest;
    }

    public UserGalleryRequest getUserGalleryByGalleryId(int galleryId) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        UserGalleryRequest userGalleryRequest = restTemplate.getForObject("http://www.worldofanime.com/api/rest/albums/view/" + galleryId + "?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret, UserGalleryRequest.class);

        return userGalleryRequest;
    }

    public void ensureUserAccount(com.worldofanime.classic.model.api.UserProfile profile, String email) {

        // This method is used to ensure there is a User and UserProfile entry in the database for this user
        // It should be called whenever the /profile/{user} page is reached, or upon user login,
        // or any other time we want to ensure that there is a proper User and UserProfile entry available

        Users user = usersRepository.findById(profile.getUserId()).orElse(null);

        if (user == null) {
            createAndReturnNewUser(profile, email);
        } else if (email != null && user.getEmail() == null) {
            // If the user is not null, email is not null, and user.getEmail() is null, then this is their first time
            // logging in after a profile has already been made for them, and we need to update it

            user.setEmail(email);
            usersRepository.saveAndFlush(user);
        }
    }

    public Users createAndReturnNewUser(com.worldofanime.classic.model.api.UserProfile profile, String email) {

      Users user = new Users();
      int userProfileId = createAndReturnNewUserProfileId();

      user.setId(profile.getUserId());
      user.setUsername(profile.getUsername());
      user.setEmail(email);
      user.setUserProfileId(userProfileId);
      Users returnUser = usersRepository.saveAndFlush(user);

      return returnUser;
    }

    public int createAndReturnNewUserProfileId() {

      com.worldofanime.classic.model.UserProfile newProfile = userProfileRepository.saveAndFlush(new com.worldofanime.classic.model.UserProfile());

      // logger.info("Returning new user profile with an id of " + newProfile.getId());

      return newProfile.getId();
    }

    public void setUserProfileNowAction(String action, String type, Integer userId) {

        Users user = usersRepository.findById(userId).orElse(null);

        if (user != null) {
            UserProfile userProfile = userProfileRepository.findById(user.getUserProfileId()).orElse(null);

            if (userProfile != null) {

                if (type.equals("now_watching")) {
                    userProfile.setNowWatching(action);
                }

                if (type.equals("now_reading")) {
                    userProfile.setNowReading(action);
                }

                if (type.equals("now_playing")) {
                    userProfile.setNowPlaying(action);
                }

                if (type.equals("now_doing")) {
                    userProfile.setNowDoing(action);
                }                                                

                userProfileRepository.saveAndFlush(userProfile);
            }
        }
    }

    public void deleteUserProfileNowActions(Integer userId) {

        Users user = usersRepository.findById(userId).orElse(null);

        if (user != null) {
            UserProfile userProfile = userProfileRepository.findById(user.getUserProfileId()).orElse(null);

            if (userProfile != null) {

                userProfile.setNowWatching("");
                userProfile.setNowReading("");
                userProfile.setNowPlaying("");
                userProfile.setNowDoing("");

                userProfileRepository.saveAndFlush(userProfile);
            }
        }

    }

    public void updateUserLastActivityDate(Integer userId) {

        Users user = usersRepository.findById(userId).orElse(null);

        if (user != null) {
            user.setLatestActivityDate(Calendar.getInstance().getTime());
            usersRepository.saveAndFlush(user);
        }
    }

}