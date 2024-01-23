package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFriendsBody {

  @JsonProperty("canAddToList")
  private int canAddToList;

  @JsonProperty("totalItemCount")
  private int totalItemCount;

  @JsonProperty("friends")
  private List<UserProfile> friends;  

  public UserFriendsBody() { }

  public int getCanAddToList() {
   	return canAddToList;
  }

  public int getTotalItemCount() {
    return totalItemCount;
  }

  public List<UserProfile> getFriends() {
    return friends;
  }  

  public void setCanAddToList(int canAddToList) {
   	this.canAddToList = canAddToList;
  }

  public void setTotalItemCount(int totalItemCount) {
    this.totalItemCount = totalItemCount;
  }

  public void setFriends(List<UserProfile> friends) {
  this.friends = friends;
  }  

}