package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Body {

  @JsonProperty("isSitemember")
  private int isSiteMember;

  @JsonProperty("page")
  private int page;

  @JsonProperty("totalItemCount")
  private int totalItemCount;

  public Body() { }

  public int getIsSiteMember() {
   	return isSiteMember;
  }

  public int getPage() {
  	return page;
  }

  public int totalItemCount() {
  	return totalItemCount;
  }  

  public void setIsSiteMember(int isSiteMember) {
   	this.isSiteMember = isSiteMember;
  }

  public void setPage(int page) {
  	this.page = page;
  }

  public void setTotalItemCount(int totalItemCount) {
  	this.totalItemCount = totalItemCount;
  }  

}