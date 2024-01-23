package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("body")
  private String body;

  public InfoRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public String getBody() {
  	return body;
  }

  public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setBody(String body) {
  	this.body = body;
  }

}