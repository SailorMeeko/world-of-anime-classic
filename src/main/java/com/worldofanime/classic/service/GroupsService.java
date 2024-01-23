package com.worldofanime.classic.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.worldofanime.classic.model.api.UserGroupsRequest;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.MediaType;
import java.util.Arrays;

@Service
public class GroupsService {

	@Value("${rest.api.oauth_consumer_key}")
	private String oauthConsumerKey;

	@Value("${rest.api.oauth_consumer_secret}")
	private String oauthConsumerSecret;	

    public UserGroupsRequest getUserGroups(int userId) {

    	RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        UserGroupsRequest userGroupsRequest = restTemplate.getForObject("http://www.worldofanime.com/api/rest/groups?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&user_id=" + userId, UserGroupsRequest.class);

        return userGroupsRequest;
    }


}