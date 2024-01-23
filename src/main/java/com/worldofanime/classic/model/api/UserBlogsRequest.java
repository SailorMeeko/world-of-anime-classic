package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBlogsRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserBlogsBody body;

  public UserBlogsRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserBlogsBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserBlogsBody body) {
  	this.body = body;
  }

}