package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldofanime.classic.model.api.UserNotificationsBody;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserNotificationsRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserNotificationsBody body;

  public UserNotificationsRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserNotificationsBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserNotificationsBody body) {
  	this.body = body;
  }

}