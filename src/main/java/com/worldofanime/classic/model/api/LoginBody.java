package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginBody {

  @JsonProperty("oauth_token")
  private String oauthToken;

  @JsonProperty("oauth_secret")
  private String oauthSecret;

  @JsonProperty("user")
  private UserProfile user;  

  public LoginBody() { }

  public String getOauthToken() {
   	return oauthToken;
  }

  public String getOauthSecret() {
  	return oauthSecret;
  }

  public UserProfile getUser() {
    return user;
  }  

  public void setOauthToken(String oauthToken) {
   	this.oauthToken = oauthToken;
  }

  public void setOauthSecret(String oauthSecret) {
  	this.oauthSecret = oauthSecret;
  }

  public void setUser(UserProfile user) {
  this.user = user;
  }  

}