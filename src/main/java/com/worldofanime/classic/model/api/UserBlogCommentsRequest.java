package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBlogCommentsRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserBlogCommentsBody body;

  public UserBlogCommentsRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserBlogCommentsBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserBlogCommentsBody body) {
  	this.body = body;
  }

}