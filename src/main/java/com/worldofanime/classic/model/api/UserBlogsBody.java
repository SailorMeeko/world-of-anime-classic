package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBlogsBody {

  @JsonProperty("canCreate")
  private int canCreate;

  @JsonProperty("totalItemCount")
  private int totalItemCount;

  @JsonProperty("response")
  private List<Blog> blogs;  

  public UserBlogsBody() { }

  public int getCanCreate() {
    return canCreate;
  }

  public int getTotalItemCount() {
    return totalItemCount;
  }

  public List<Blog> getBlogs() {
    return blogs;
  }  

  public void setCanCreate(int canCreate) {
    this.canCreate = canCreate;
  }

  public void setTotalItemCount(int totalItemCount) {
    this.totalItemCount = totalItemCount;
  }

  public void setBlogs(List<Blog> blogs) {
  this.blogs = blogs;
  }  

}