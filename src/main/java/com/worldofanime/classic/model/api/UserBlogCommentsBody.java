package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBlogCommentsBody {

	@JsonProperty("viewAllComments")
	private List<Comment> viewAllComments;  

	public UserBlogCommentsBody() { }

	public List<Comment> getViewAllComments() {
		return viewAllComments;
	}

	public void setViewAllComments(List<Comment> viewAllComments) {
		this.viewAllComments = viewAllComments;
	}  

}