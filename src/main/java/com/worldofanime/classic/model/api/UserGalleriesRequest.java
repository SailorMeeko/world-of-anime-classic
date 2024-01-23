package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGalleriesRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private UserGalleriesBody body;

  public UserGalleriesRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public UserGalleriesBody getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(UserGalleriesBody body) {
  	this.body = body;
  }

}