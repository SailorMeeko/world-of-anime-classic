package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

  @JsonProperty("status_code")
  private String statusCode;

  public Request() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

}