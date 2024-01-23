package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserActivityFeedsData {

  @JsonProperty("feed")
  private ActivityFeed feed;

  @JsonProperty("canComment")
  private int canComment;

  public UserActivityFeedsData() { }

  public ActivityFeed getFeed() {
    return feed;
  }  

  public int getCanComment() {
    return canComment;
  }

  public void setFeed(ActivityFeed feed) {
    this.feed = feed;
  }  

  public void setCanComment(int canComment) {
    this.canComment = canComment;
  }

}