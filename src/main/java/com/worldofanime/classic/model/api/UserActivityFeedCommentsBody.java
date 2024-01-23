package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserActivityFeedCommentsBody {

  @JsonProperty("viewAllComments")
  private List<ActivityFeedComment> comments;

  @JsonProperty("isLike")
  private int isLike;

  @JsonProperty("canComment")
  private int canComment;

  @JsonProperty("canDelete")
  private int canDelete;

  @JsonProperty("getTotalComments")
  private int totalComments;

  @JsonProperty("getTotalLikes")
  private int totalLikes;

  public UserActivityFeedCommentsBody() { }

  public List<ActivityFeedComment> getComments() {
  	return comments;
  }  

  public int getIsLike() {
    return isLike;
  }

  public int getCanComment() {
  	return canComment;
  }

  public int getCanDelete() {
    return canDelete;
  }

  public int getTotalComments() {
    return totalComments;
  }

  public int getTotalLikes() {
    return totalLikes;
  }

  public void setData(List<ActivityFeedComment> comments) {
  	this.comments = comments;
  }  

  public void setIsLike(int isLike) {
    this.isLike = isLike;
  }

  public void setCanComment(int canComment) {
  	this.canComment = canComment;
  }

  public void setCanDelete(int canDelete) {
    this.canDelete = canDelete;
  }

  public void setTotalComments(int totalComments) {
    this.totalComments = totalComments;
  }

  public void setTotalLikes(int totalLikes) {
    this.totalLikes = totalLikes;
  }

}