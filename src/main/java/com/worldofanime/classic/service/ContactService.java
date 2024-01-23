package com.worldofanime.classic.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.worldofanime.classic.model.api.ContactRequest;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import java.util.Arrays;

@Service
public class ContactService {

    @Value("${rest.api.oauth_consumer_key}")
    private String oauthConsumerKey;

    @Value("${rest.api.oauth_consumer_secret}")
    private String oauthConsumerSecret; 

    public ContactRequest sendContactMessage(String name, String email, String message) {

        message = "This message was sent via World of Anime Classic.\n\n" + message;

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("oauth_consumer_key", oauthConsumerKey);
        map.add("oauth_consumer_secret", oauthConsumerSecret);
        map.add("name", name);
        map.add("email", email);
        map.add("body", message);

        ContactRequest contactRequest = restTemplate.postForObject("http://www.worldofanime.com/api/rest/help/contact", map, ContactRequest.class);

        return contactRequest;
    }    

}
