package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldofanime.classic.model.api.UserProfileBody;
import com.worldofanime.classic.model.api.UserProfile;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserProfileBody body;

  public UserProfileRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserProfileBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserProfileBody body) {
  	this.body = body;
  }

}