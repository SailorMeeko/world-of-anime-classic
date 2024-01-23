package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldofanime.classic.model.api.UserGroupsBody;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGroupsRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserGroupsBody body;

  public UserGroupsRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserGroupsBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserGroupsBody body) {
  	this.body = body;
  }

}