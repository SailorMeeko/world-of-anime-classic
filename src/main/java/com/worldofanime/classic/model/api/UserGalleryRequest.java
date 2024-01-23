package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGalleryRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserGalleryBody body;

  public UserGalleryRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserGalleryBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserGalleryBody body) {
  	this.body = body;
  }

}