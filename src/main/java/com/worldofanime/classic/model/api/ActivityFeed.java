package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityFeed {

	@JsonProperty("action_id")
	private int actionId;

	@JsonProperty("type")
	private String type;

	@JsonProperty("subject_type")
	private String subjectType;

	@JsonProperty("subject_id")
	private int subjectId;

	@JsonProperty("object_type")
	private String objectType;

	@JsonProperty("object_id")
	private int objectId;

	@JsonProperty("body")
	private String body;

	// params - SKIP FOR NOW

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("date")
    private Date date;

    @JsonProperty("attachment_count")
    private int attachmentCount;

    @JsonProperty("comment_count")
    private int commentCount;

    @JsonProperty("like_count")
    private int likeCount;

    @JsonProperty("privacy")
    private String privacy;

    @JsonProperty("commentable")
    private int commentable;

    @JsonProperty("shareable")
    private int shareable;

    @JsonProperty("user_agent")
    private String userAgent;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("modified_date")
    private Date modifiedDate;

    @JsonProperty("feed_title")
    private String feedTitle; 

    @JsonProperty("object")
    private UserProfile object;

    private UserProfile poster;

    private List<ActivityFeedComment> comments;
 
/*
    @JsonProperty("subject")
    private UserProfile subject;
*/
 	public ActivityFeed() { }

	public int getActionId() {
		return actionId;
	}

	public String getType() {
		return type;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public String getObjectType() {
		return objectType;
	}

	public int getObjectId() {
		return objectId;
	}

	public String getBody() {
		return body;
	}

	public Date getDate() {
		return date;
	}

	public int getAttachmentCount() {
		return attachmentCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public String getPrivacy() {
		return privacy;
	}

	public int getCommentable() {
		return commentable;
	}

	public int getShareable() {
		return shareable;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public String getFeedTitle() {
		return feedTitle;
	}

	public UserProfile getObject() {
		return object;
	}

	public UserProfile getPoster() {
		return poster;
	}

	public List<ActivityFeedComment> getComments() {
		return comments;
	}

/*
	public UserProfile getSubject() {
		return subject;
	}
*/

	public void setActionId(int actionId) {
    	this.actionId = actionId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setStatusDate(Date date) {
		this.date = date;
	}

	public void setAttachmentCount(int attachmentCount) {
		this.attachmentCount = attachmentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public void setCommentable(int commentable) {
		this.commentable = commentable;
	}

	public void setShareable(int shareable) {
		this.shareable = shareable;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setFeedTitle(String feedTitle) {
		this.feedTitle = feedTitle;
	}

	public void setObject(UserProfile object) {
		this.object = object;
	}

	public void setPoster(UserProfile poster) {
		this.poster = poster;
	}

	public void setComments(List<ActivityFeedComment> comments) {
		this.comments = comments;
	}

/*
	public void setSubject(UserProfile subject) {
		this.subject = subject;
	}
*/

}