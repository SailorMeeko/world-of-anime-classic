package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFriendRequestAcceptOrRejectRequest {

  @JsonProperty("status_code")
  private String statusCode;

  public UserFriendRequestAcceptOrRejectRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }
 public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

}