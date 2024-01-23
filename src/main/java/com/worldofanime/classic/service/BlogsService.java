package com.worldofanime.classic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.worldofanime.classic.model.api.UserBlogsRequest;
import com.worldofanime.classic.model.api.UserBlogCommentsRequest;
import com.worldofanime.classic.model.api.UserBlogRequest;
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

@Service
public class BlogsService {

    @Value("${rest.api.oauth_consumer_key}")
    private String oauthConsumerKey;

    @Value("${rest.api.oauth_consumer_secret}")
    private String oauthConsumerSecret;    

    private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);        

    public UserBlogsRequest getLatestBlogs(int numberOfBlogs) {

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        String url = "http://www.worldofanime.com/api/rest/blogs?oauth_consumer_key=" + oauthConsumerKey + "&oauth_consumer_secret=" + oauthConsumerSecret + "&page=1&limit=" + numberOfBlogs;
        // logger.info("Calling " + url);
        UserBlogsRequest userBlogsRequest = restTemplate.getForObject(url, UserBlogsRequest.class);

        return userBlogsRequest;
    }


}