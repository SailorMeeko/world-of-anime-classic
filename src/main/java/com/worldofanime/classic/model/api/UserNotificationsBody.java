package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserNotificationsBody {

  @JsonProperty("notifications")
  private Integer numNotifications;  

  @JsonProperty("friend_requests")
  private Integer numFriendRequests;

  @JsonProperty("messages")
  private Integer numMessages;

  public UserNotificationsBody() { }

  public Integer getNumNotifications() {
   	return numNotifications;
  }

  public Integer getNumFriendRequests() {
    return numFriendRequests;
  }

  public Integer getNumMessages() {
    return numMessages;
  }

  public Integer getTotalNotifications() {
    return numNotifications + numFriendRequests;
  }

  public void setNumNotifications(Integer numNotifications) {
   	this.numNotifications = numNotifications;
  }

  public void setNumFriendRequests(Integer numFriendRequests) {
    this.numFriendRequests = numFriendRequests;
  }

  public void setNumMessage(Integer numMessages) {
    this.numMessages = numMessages;
  }

}