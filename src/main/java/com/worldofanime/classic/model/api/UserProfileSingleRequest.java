package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldofanime.classic.model.api.UserProfileBody;
import com.worldofanime.classic.model.api.UserProfile;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileSingleRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserProfileSingleBody body;

  public UserProfileSingleRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserProfileSingleBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserProfileSingleBody body) {
  	this.body = body;
  }

}