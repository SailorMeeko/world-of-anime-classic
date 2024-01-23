package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGroupsBody {

  @JsonProperty("canCreate")
  private int canCreate;

  @JsonProperty("page")
  private int page;

  @JsonProperty("response")
  private List<Group> response;  

  @JsonProperty("totalItemCount")
  private int totalItemCount;

  public UserGroupsBody() { }

  public int getCanCreate() {
   	return canCreate;
  }

  public int getPage() {
  	return page;
  }

  public int getTotalItemCount() {
    return totalItemCount;
  }

  public List<Group> getResponse() {
    return response;
  }  

  public void setIsSiteMember(int canCreate) {
   	this.canCreate = canCreate;
  }

  public void setPage(int page) {
  	this.page = page;
  }

  public void setResponse(List<Group> response) {
  this.response = response;
  }  

  public void setTotalItemCount(int totalItemCount) {
    this.totalItemCount = totalItemCount;
  }  

}