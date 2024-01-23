package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserActivityFeedsBody {

  @JsonProperty("data")
  private List<UserActivityFeedsData> data;

  @JsonProperty("defaultFeedCount")
  private int defaultFeedCount;

  @JsonProperty("activityCount")
  private int activityCount;

  public UserActivityFeedsBody() { }

  public List<UserActivityFeedsData> getData() {
    return data;
  }  

  public int getDefaultFeedCount() {
    return defaultFeedCount;
  }

  public int getActivityCount() {
  	return activityCount;
  }

  public void setData(List<UserActivityFeedsData> data) {
  	this.data = data;
  }  

  public void setDefaultFeedCount(int defaultFeedCount) {
    this.defaultFeedCount = defaultFeedCount;
  }

  public void setActivityCount(int activityCount) {
  	this.activityCount = activityCount;
  }

}