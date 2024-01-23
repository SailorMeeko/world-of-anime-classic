package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileSingleBody {

  @JsonProperty("response")
  private UserProfile profile;  

  @JsonProperty("totalItemCount")
  private int totalItemCount;

  public UserProfileSingleBody() { }

  public UserProfile getProfile() {
    return profile;
  }  

  public void setProfile(UserProfile profile) {
  this.profile = profile;
  }  

}