package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification {

	@JsonProperty("notification_id")
	private int notificationId;

	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("subject_type")
	private String subjectType;

	@JsonProperty("subject_id")
	private int subjectId;

	@JsonProperty("object_type")
	private String objectType;

	@JsonProperty("object_id")
	private int objectId;

	@JsonProperty("type")
	private String type;

	@JsonProperty("read")
	private int read;

	@JsonProperty("mitigated")
	private int mitigated;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("date")
    private Date date;

    @JsonProperty("show")
    private int show;

    @JsonProperty("action_type_body")
    private String actionTypeBody;

    @JsonProperty("feed_title")
    private String feedTitle;

    // action_type_body_params
    // request_action

    @JsonProperty("subject")
    private UserProfile subject;

    @JsonProperty("object")
    private UserProfile object;

	public Notification() { }

	public int getNotificationId() {
		return notificationId;
	}

	public int getUserId() {
		return userId;
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

	public String getType() {
		return type;
	}

	public int getRead() {
		return read;
	}

	public int getMitigated() {
		return mitigated;
	}

	public Date getDate() {
		return date;
	}

	public int getShow() {
		return show;
	}

	public String getActionTypeBody() {
		return actionTypeBody;
	}

	public String getFeedTitle() {
		return feedTitle;
	}

	public UserProfile getSubject() {
		return subject;
	}

	public UserProfile getObject() {
		return object;
	}

	public void setNotificationId(int notificationId) {
    this.notificationId = notificationId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public void setType(String type) {
		this.type = type;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public void setMitigated(int mitigated) {
		this.mitigated = mitigated;
	}

	public void setStatusDate(Date date) {
		this.date = date;
	}

	public void setShow(int show) {
		this.show = show;
	}

	public void setActionTypeBody(String actionTypeBody) {
		this.actionTypeBody = actionTypeBody;
	}

	public void setFeedTitle(String feedTitle) {
		this.feedTitle = feedTitle;
	}

	public void setSubject(UserProfile subject) {
		this.subject = subject;
	}

	public void setObject(UserProfile object) {
		this.object = object;
	}

}