package com.worldofanime.classic.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.beans.factory.annotation.Autowired;
import com.worldofanime.classic.model.api.UserProfile;
import com.worldofanime.classic.model.api.UserNotificationsRequest;
import com.worldofanime.classic.model.api.UserNotificationsBody;
import com.worldofanime.classic.model.api.LoggedInUserProfileRequest;
import com.worldofanime.classic.model.api.UserFriendRequestsRequest;
import com.worldofanime.classic.service.ProfileService;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 



@ControllerAdvice()
public class GlobalController {

  private static final Logger logger = LoggerFactory.getLogger(GlobalController.class);     

  @Autowired
  ProfileService profileService;

  @Value("${local.api.path}")
  private String localApiPath;

  @Value("${default.theme}")
  private String defaultTheme;

  @Value("${ad.top}")
  private String adTop;

  @Value("${ad.side}")
  private String adSide;

  @Value("${default.meta_title}")
  private String metaTitle;

  @Value("${default.meta_keywords}")
  private String metaKeywords;

  @Value("${default.meta_description}")
  private String metaDescription;

  @ModelAttribute("loggedInUser")
  public UserProfile getLoggedInUser(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {
    
    if (!com.google.common.base.Strings.isNullOrEmpty(oauthToken)) {
      
      RestTemplate restTemplate = new RestTemplate();
      LoggedInUserProfileRequest loggedInUserProfileRequest = restTemplate.getForObject(localApiPath + "/api/profile/logged-in-user-profile?oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret, LoggedInUserProfileRequest.class);

      profileService.updateUserLastActivityDate(loggedInUserProfileRequest.getBody().getResponse().getUserId());

      return loggedInUserProfileRequest.getBody().getResponse();
    } else {
      return new UserProfile(); // Empty user profile
    }

  }

  @ModelAttribute("userNotifications")
  public UserNotificationsBody getUserNotifications(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {

    if (!com.google.common.base.Strings.isNullOrEmpty(oauthToken)) {
      
      RestTemplate restTemplate = new RestTemplate();
      UserNotificationsRequest userNotificationsRequest = restTemplate.getForObject(localApiPath + "/api/profile/num-notifications?oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret, UserNotificationsRequest.class);

      return userNotificationsRequest.getBody();
    } else {
      return new UserNotificationsBody(); // Empty user notifications
    }

  }

  @ModelAttribute("userFriendRequestsNum")
  public int getUserNotificationsNum(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret) {

    if (!com.google.common.base.Strings.isNullOrEmpty(oauthToken)) {

      UserFriendRequestsRequest userFriendRequestsRequest = profileService.getUserFriendRequestsLoggedInUserProfile(oauthToken, oauthSecret);

      return userFriendRequestsRequest.getBody().getTotalItemCount();
    } else {
      return 0;
    }

  }

  @ModelAttribute("theme")
  public String getTheme(@CookieValue(name = "theme", required = false) String theme) {

    return (!com.google.common.base.Strings.isNullOrEmpty(theme)) ? theme : defaultTheme;
  }

  @ModelAttribute("adTop")
  public String getAdTop() {

    return adTop;
  }

  @ModelAttribute("adSide")
  public String getAdSide() {

    return adSide;
  }

  @ModelAttribute("metaTitle")
  public String getMetaTitle() {

    return metaTitle;
  }

  @ModelAttribute("metaKeywords")
  public String getMetaKeywords() {

    return metaKeywords;
  }

  @ModelAttribute("metaDescription")
  public String getMetaDescription() {

    return metaDescription;
  }

}