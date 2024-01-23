package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldofanime.classic.model.api.UserInfoBody;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserInfoBody body;

  public UserInfoRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserInfoBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserInfoBody body) {
  	this.body = body;
  }

}