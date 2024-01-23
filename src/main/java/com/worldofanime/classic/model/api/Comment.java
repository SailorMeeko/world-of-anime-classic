package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

	@JsonProperty("comment_id")
	private int commentId;

	@JsonProperty("user_id")
	private int userId;	

	@JsonProperty("author_image")
	private String authorImage;

	@JsonProperty("author_image_normal")
	private String authorImageNormal;

	@JsonProperty("author_image_profile")
	private String authorImageProfile;

	@JsonProperty("author_image_icon")
	private String authorImageIcon;	

	@JsonProperty("content_url")
	private String contentUrl;		

	@JsonProperty("author_title")
	private String authorTitle;

	@JsonProperty("comment_body")
	private String commentBody;	

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("comment_date")
    private Date commentDate;	

	@JsonProperty("like_count")
	private int likeCount;

	public Comment() { }

	public int getCommentId() {
		return commentId;
	}

	public int getUserId() {
		return userId;
	}

	public String getAuthorImage() {
		return authorImage;
	}

	public String getAuthorImageNormal() {
		return authorImageNormal;
	}	

	public String getAuthorImageProfile() {
		return authorImageProfile;
	}

	public String getAuthorImageIcon() {
		return authorImageIcon;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public String getAuthorTitle() {
		return authorTitle;
	}

	public String getUsername() {
		return contentUrl.replaceAll("http://www.worldofanime.com/profile/", "");
	}	

	public String getCommentBody() {
		return commentBody;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public int getLikeCount() {
		return likeCount;
	}	

	public void setCommentId(int commentId) {
    	this.commentId = commentId;
	}

	public void setUserId(int userId) {
    	this.userId = userId;
	}

	public void setAuthorImage(String authorImage) {
		this.authorImage = authorImage;
	}

	public void setAuthorImageNormal(String authorImageNormal) {
		this.authorImageNormal = authorImageNormal;
	}

	public void setAuthorImageProfile(String authorImageProfile) {
		this.authorImageProfile = authorImageProfile;
	}

	public void setAuthorImageIcon(String authorImageIcon) {
		this.authorImageIcon = authorImageIcon;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public void setAuthorTitle(String authorTitle) {
		this.authorTitle = authorTitle;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}		

}