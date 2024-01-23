package com.worldofanime.classic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.MediaType;
import java.util.List;

import org.springframework.web.bind.annotation.CookieValue;
import com.worldofanime.classic.service.ProfileService;
import com.worldofanime.classic.service.GroupsService;
import com.worldofanime.classic.service.LoginService;
import com.worldofanime.classic.service.InfoService;
import com.worldofanime.classic.model.api.UserProfileRequest;
import com.worldofanime.classic.model.api.UserProfileSingleRequest;
import com.worldofanime.classic.model.api.LoggedInUserProfileRequest;
import com.worldofanime.classic.model.api.UserInfoRequest;
import com.worldofanime.classic.model.api.UserGroupsRequest;
import com.worldofanime.classic.model.api.InfoRequest;
import com.worldofanime.classic.model.api.LoginRequest;
import com.worldofanime.classic.model.api.LogoutRequest;
import com.worldofanime.classic.model.api.UserFriendsRequest;
import com.worldofanime.classic.model.api.UserBlogsRequest;
import com.worldofanime.classic.model.api.UserGalleriesRequest;
import com.worldofanime.classic.model.api.UserGalleryRequest;
import com.worldofanime.classic.model.api.UserProfile;
import com.worldofanime.classic.model.api.UserNotificationsRequest;
import com.worldofanime.classic.model.api.UserFriendRequestsRequest;
import com.worldofanime.classic.model.api.UserFriendRequestAcceptOrRejectRequest;
import com.worldofanime.classic.model.api.UserActivityFeedsRequest;
import com.worldofanime.classic.model.api.UserActivityFeedCommentsRequest;
import com.worldofanime.classic.model.api.Notification;
import com.worldofanime.classic.model.api.Blog;
import com.worldofanime.classic.model.api.Gallery;
 
@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    ProfileService profileService;

    @Autowired
    GroupsService groupsService;

    @Autowired
    LoginService loginService;

    @Autowired
    InfoService infoService;

    private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);    

    @RequestMapping(value = "/profile/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserProfile(@PathVariable("username") String username) {

        UserProfileRequest userProfile = profileService.getUserProfile(username);
        return new ResponseEntity<UserProfileRequest>(userProfile, HttpStatus.OK);
    }

    @RequestMapping(value = "/profile/by_id/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserProfileByUsedId(@PathVariable("userId") int userId, @CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {

        UserProfileSingleRequest userProfile = profileService.getUserProfileByUserId(userId, oauthToken, oauthSecret);
        return new ResponseEntity<UserProfileSingleRequest>(userProfile, HttpStatus.OK);
    }    

    @RequestMapping(value = "/profile/user_information/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserInformation(@PathVariable("user_id") int userId, @CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {

        UserInfoRequest userInfo = profileService.getUserInformation(userId, oauthToken, oauthSecret);
        return new ResponseEntity<UserInfoRequest>(userInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/online_se", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOnlineUsersSE() {

        UserProfileRequest userProfile = profileService.getOnlineUsersSE();
        return new ResponseEntity<UserProfileRequest>(userProfile, HttpStatus.OK);
    }    

    @RequestMapping(value = "/groups/user/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserGroups(@PathVariable("user_id") int userId) {

        UserGroupsRequest userGroupsRequest = groupsService.getUserGroups(userId);
        return new ResponseEntity<UserGroupsRequest>(userGroupsRequest, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("ip") String ipAddress) {

        LoginRequest loginRequest = loginService.login(email, password, ipAddress);
        return new ResponseEntity<LoginRequest>(loginRequest, HttpStatus.OK);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> logout(@RequestParam("oauth_token") String oauthToken,@RequestParam("oauth_secret") String oauthSecret) {

        LogoutRequest logoutRequest = loginService.logout(oauthToken, oauthSecret);
        return new ResponseEntity<LogoutRequest>(logoutRequest, HttpStatus.OK);
    }

    @RequestMapping(value ="/profile/logged-in-user-profile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLoggedInUserProfile(@RequestParam("oauth_token") String oauthToken,@RequestParam("oauth_secret") String oauthSecret) {

        LoggedInUserProfileRequest loggedInUserProfileRequest = profileService.getLoggedInUserProfile(oauthToken, oauthSecret);
        return new ResponseEntity<LoggedInUserProfileRequest>(loggedInUserProfileRequest, HttpStatus.OK);
    }

    @RequestMapping(value = "/profile/friends", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserFriendsLoggedInUser(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {

        UserFriendsRequest userFriendsRequest = profileService.getUserFriendsLoggedInUserProfile(oauthToken, oauthSecret);
        return new ResponseEntity<List<UserProfile>>(userFriendsRequest.getBody().getFriends(), HttpStatus.OK);
    }

    @RequestMapping(value = "/profile/friend-requests", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserFriendRequestsLoggedInUser(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {

        UserFriendRequestsRequest userFriendRequestsRequest = profileService.getUserFriendRequestsLoggedInUserProfile(oauthToken, oauthSecret);
        return new ResponseEntity<List<Notification>>(userFriendRequestsRequest.getBody().getNotifications(), HttpStatus.OK);
    }    

    @RequestMapping(value = "/profile/friends/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserFriendsByUserId(@PathVariable("user_id") int userId, @CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {

        UserFriendsRequest userFriendsRequest = profileService.getUserFriends(userId, oauthToken, oauthSecret);
        return new ResponseEntity<List<UserProfile>>(userFriendsRequest.getBody().getFriends(), HttpStatus.OK);
    }

    @RequestMapping(value = "/profile/blog/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserBlogsByUserId(@PathVariable("user_id") int userId) {

        UserBlogsRequest userBlogsRequest = profileService.getUserBlogs(userId);
        return new ResponseEntity<List<Blog>>(userBlogsRequest.getBody().getBlogs(), HttpStatus.OK);
    }    

    @RequestMapping(value = "/profile/gallery/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserGalleriesByUserId(@PathVariable("user_id") int userId) {

        UserGalleriesRequest userGalleriesRequest = profileService.getUserGalleries(userId);
        return new ResponseEntity<List<Gallery>>(userGalleriesRequest.getBody().getGalleries(), HttpStatus.OK);
    }

    @RequestMapping(value = "/profile/gallery/view_gallery/{gallery_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserGalleryByGalleryId(@PathVariable("gallery_id") int galleryId) {

        UserGalleryRequest userGalleryRequest = profileService.getUserGalleryByGalleryId(galleryId);
        return new ResponseEntity<UserGalleryRequest>(userGalleryRequest, HttpStatus.OK);
    }            

    @RequestMapping(value = "/profile/num-notifications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNumNotifications(@RequestParam("oauth_token") String oauthToken,@RequestParam("oauth_secret") String oauthSecret) {

        UserNotificationsRequest userNotificationsRequest = profileService.getUserNumNotifications(oauthToken, oauthSecret);
        return new ResponseEntity<UserNotificationsRequest>(userNotificationsRequest, HttpStatus.OK);
    }

    @RequestMapping(value = "/terms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTerms() {

        InfoRequest infoRequest = infoService.getTerms();
        return new ResponseEntity<InfoRequest>(infoRequest, HttpStatus.OK);
    }

    @RequestMapping(value = "/profile/friend_request/accept", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> acceptFriendRequest(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret, @RequestParam("friend") int userId) {

        UserFriendRequestAcceptOrRejectRequest userFriendRequestAcceptRequest = profileService.acceptFriendRequest(oauthToken, oauthSecret, userId);
        return new ResponseEntity<UserFriendRequestAcceptOrRejectRequest>(userFriendRequestAcceptRequest, HttpStatus.OK);
    }

    @RequestMapping(value = "/profile/friend_request/reject", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> rejectFriendRequest(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret, @RequestParam("friend") int userId) {

        UserFriendRequestAcceptOrRejectRequest userFriendRequestRejectRequest = profileService.rejectFriendRequest(oauthToken, oauthSecret, userId);
        return new ResponseEntity<UserFriendRequestAcceptOrRejectRequest>(userFriendRequestRejectRequest, HttpStatus.OK);
    }

    @RequestMapping(value = "/profile/activity_feeds/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserActivityFeeds(@PathVariable("user_id") int userId) {

        UserActivityFeedsRequest userActivityFeedsRequest = profileService.getUserActivityFeeds(userId);
        return new ResponseEntity<UserActivityFeedsRequest>(userActivityFeedsRequest, HttpStatus.OK);
    }    

    @RequestMapping(value = "/profile/activity_feeds/comments/{action_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserActivityFeedComments(@PathVariable("action_id") int actionId) {

        UserActivityFeedCommentsRequest userActivityFeedCommentsRequest = profileService.getUserActivityFeedComments(actionId);
        return new ResponseEntity<UserActivityFeedCommentsRequest>(userActivityFeedCommentsRequest, HttpStatus.OK);
    }

    @RequestMapping(value = "/profile/update/now_action", method = RequestMethod.POST)
    public void setUserProfileNowAction(@RequestParam("action") String action, @RequestParam("type") String type, @ModelAttribute("loggedInUser") UserProfile loggedInUser) {

        profileService.setUserProfileNowAction(action, type, loggedInUser.getUserId());
    }

    @RequestMapping(value = "/profile/update/delete_now_blocks", method = RequestMethod.GET)
    public void setUserProfileNowAction(@ModelAttribute("loggedInUser") UserProfile loggedInUser) {

        profileService.deleteUserProfileNowActions(loggedInUser.getUserId());
    }

}