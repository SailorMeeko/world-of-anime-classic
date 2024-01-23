package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldofanime.classic.model.api.UserProfileBody;
import com.worldofanime.classic.model.api.UserProfile;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserActivityFeedsRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserActivityFeedsBody body;  

  public UserActivityFeedsRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserActivityFeedsBody getBody() {
    return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserActivityFeedsBody body) {
    this.body = body;
  }

}