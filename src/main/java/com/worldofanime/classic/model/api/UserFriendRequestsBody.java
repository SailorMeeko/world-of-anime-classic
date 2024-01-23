package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFriendRequestsBody {

  @JsonProperty("totalItemCount")
  private int totalItemCount;

  @JsonProperty("response")
  private List<Notification> notifications;  

  public UserFriendRequestsBody() { }


  public int getTotalItemCount() {
    return totalItemCount;
  }

  public List<Notification> getNotifications() {
    return notifications;
  }  

  public void setTotalItemCount(int totalItemCount) {
    this.totalItemCount = totalItemCount;
  }

  public void setFriends(List<Notification> notifications) {
  this.notifications = notifications;
  }  

}