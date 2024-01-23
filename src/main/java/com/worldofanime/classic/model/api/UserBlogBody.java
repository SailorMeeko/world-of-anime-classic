package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBlogBody {

	@JsonProperty("response")
	private Blog response;  

	public UserBlogBody() { }

	public Blog getResponse() {
		return response;
	}

	public void setResponse(Blog response) {
		this.response = response;
	}  

}