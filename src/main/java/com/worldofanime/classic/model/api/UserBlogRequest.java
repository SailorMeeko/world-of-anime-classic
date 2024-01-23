package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBlogRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserBlogBody body;

  public UserBlogRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserBlogBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserBlogBody body) {
  	this.body = body;
  }

}