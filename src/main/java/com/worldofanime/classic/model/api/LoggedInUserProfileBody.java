package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoggedInUserProfileBody {

  @JsonProperty("response")
  private UserProfile response;  

  public LoggedInUserProfileBody() { }

  public UserProfile getResponse() {
    return response;
  }  

  public void setResponse(UserProfile response) {
  this.response = response;
  }  

}