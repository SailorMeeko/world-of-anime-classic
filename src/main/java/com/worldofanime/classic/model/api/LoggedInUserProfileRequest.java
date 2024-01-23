package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldofanime.classic.model.api.LoggedInUserProfileBody;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoggedInUserProfileRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private LoggedInUserProfileBody body;

  public LoggedInUserProfileRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public LoggedInUserProfileBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(LoggedInUserProfileBody body) {
  	this.body = body;
  }

}