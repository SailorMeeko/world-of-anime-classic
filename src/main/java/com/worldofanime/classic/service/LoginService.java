package com.worldofanime.classic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.worldofanime.classic.model.api.LoginRequest;
import com.worldofanime.classic.model.api.LogoutRequest;
import com.worldofanime.classic.model.api.LoggedInUserProfileRequest;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import com.worldofanime.classic.model.Users;
import com.worldofanime.classic.model.Logins;
import com.worldofanime.classic.repository.LoginsRepository;
import com.worldofanime.classic.service.ProfileService;
import java.util.Arrays;
import java.util.Date;

@Service
public class LoginService {

	@Value("${rest.api.oauth_consumer_key}")
	private String oauthConsumerKey;

	@Value("${rest.api.oauth_consumer_secret}")
	private String oauthConsumerSecret;

  @Autowired
  LoginsRepository loginsRepository;

  @Autowired
  ProfileService profileService;      

  private static final Logger logger = LoggerFactory.getLogger(LoginService.class);      

    public LoginRequest login(String email, String password, String ipAddress) {

    RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
  		map.add("email", email);
  		map.add("password", password);
  		map.add("ip", ipAddress);

        LoginRequest loginRequest = restTemplate.postForObject("http://www.worldofanime.com/api/rest/login?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret, map, LoginRequest.class);

        return loginRequest;
    }

    public LogoutRequest logout(String oauthToken, String oauthSecret) {

    	RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
  		map.add("oauth_consumer_key", oauthConsumerKey);
  		map.add("oauth_consumer_secret", oauthConsumerSecret);
  		map.add("oauth_token", oauthToken);
  		map.add("oauth_secret", oauthSecret);

        LogoutRequest logoutRequest = restTemplate.postForObject("http://www.worldofanime.com/api/rest/logout", map, LogoutRequest.class);

        return logoutRequest;

    }


    public LoggedInUserProfileRequest getLoggedInUserProfile(String oauthToken, String oauthSecret) {

    	RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        LoggedInUserProfileRequest loggedInUserProfileRequest = restTemplate.getForObject("http://www.worldofanime.com/api/rest/logout?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret, LoggedInUserProfileRequest.class);

        return loggedInUserProfileRequest;
    }


    public void handleLogin(com.worldofanime.classic.model.api.UserProfile profile, String email, String ipAddress) {
      
      profileService.ensureUserAccount(profile, email);
      recordLogin(profile.getUserId(), ipAddress);
    }


    public void recordLogin(int userId, String ipAddress) {

      Logins login = new Logins();

      login.setUserId(userId);
      login.setIpAddress(ipAddress);
      loginsRepository.save(login);
    }
}