package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldofanime.classic.model.api.LoginBody;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {

  @JsonProperty("status_code")
  private String statusCode;

  @JsonProperty("error")
  private Boolean error;

  @JsonProperty("error_code")
  private String errorCode;

  @JsonProperty("body")
  private LoginBody body;

  public LoginRequest() { }

  public String getStatusCode() {
   	return statusCode;
  }

  public Boolean getError() {
    return error;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public LoginBody getBody() {
  	return body;
  }


 public void setStatusCode(String status_code) {
   	this.statusCode = status_code;
  }

  public void setError(Boolean error) {
    this.error = error;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public void setBody(LoginBody body) {
  	this.body = body;
  }

}