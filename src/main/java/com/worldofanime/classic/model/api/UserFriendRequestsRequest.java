package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldofanime.classic.model.api.UserProfileBody;
import com.worldofanime.classic.model.api.UserProfile;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFriendRequestsRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserFriendRequestsBody body;

  public UserFriendRequestsRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserFriendRequestsBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserFriendRequestsBody body) {
  	this.body = body;
  }

}