package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileBody {

  @JsonProperty("isSitemember")
  private int isSiteMember;

  @JsonProperty("page")
  private int page;

  @JsonProperty("response")
  private List<UserProfile> response;  

  @JsonProperty("totalItemCount")
  private int totalItemCount;

  public UserProfileBody() { }

  public int getIsSiteMember() {
   	return isSiteMember;
  }

  public int getPage() {
  	return page;
  }

  public int getTotalItemCount() {
    return totalItemCount;
  }

  public List<UserProfile> getResponse() {
    return response;
  }  

  public void setIsSiteMember(int isSiteMember) {
   	this.isSiteMember = isSiteMember;
  }

  public void setPage(int page) {
  	this.page = page;
  }

  public void setResponse(List<UserProfile> response) {
  this.response = response;
  }  

  public void setTotalItemCount(int totalItemCount) {
    this.totalItemCount = totalItemCount;
  }  

}