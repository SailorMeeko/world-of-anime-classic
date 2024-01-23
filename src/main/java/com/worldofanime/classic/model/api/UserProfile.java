package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile {

	@JsonProperty("user_id")
	private Integer userId;

	@JsonProperty("username")
   	private String username;

   	@JsonProperty("displayname")
   	private String displayname;

    @JsonProperty("photo_id")
    private Integer photo_id;

    @JsonProperty("status")
    private String status;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("status_date")
    private Date status_date;

   @JsonProperty("locale")
   private String locale;

   @JsonProperty("language")
   private String language;

	@JsonProperty("timezone")
   private String timezone;

   @JsonProperty("search")
	private Integer search;

   @JsonProperty("show_profileviewers")
	private Integer show_profileviewers;

   @JsonProperty("level_id")
	private Integer level_id;

   @JsonProperty("enabled")
	private Integer enabled;

   @JsonProperty("verified")
	private Integer verified;

   @JsonProperty("approved")
	private Integer approved;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   @JsonProperty("creation_date")
	private Date creation_date;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   @JsonProperty("modified_date")
	private Date modified_date;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   @JsonProperty("lastlogin_date")
   private Date lastlogin_date;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("update_date")
	private Date update_date;

	@JsonProperty("member_count")
	private Integer member_count;

	@JsonProperty("view_count")
	private Integer view_count;

	@JsonProperty("location")
	private String location;

	@JsonProperty("image")
	private String image;

	@JsonProperty("image_icon")
	private String image_icon;

	@JsonProperty("image_profile")
	private String image_profile;

	@JsonProperty("image_normal")
	private String image_normal;

	@JsonProperty("content_url")
	private String content_url;

	@JsonProperty("cover")
	private String cover;

	public UserProfile() { }

	public Integer getUserId() {
		return userId;
	}

	public String getUsername() {
    return username;
	}

	public String getDisplayName() {
		return displayname;
	}

	public Integer getPhotoId() {
		return photo_id;
	}

	public String getStatus() {
		return status;
	}

	public Date getStatusDate() {
		return status_date;
	}

	public Integer getShowProfileViewers() {
		return show_profileviewers;
	}

	public Integer getLevelId() {
		return level_id;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public Integer getVerified() {
		return verified;
	}

	public Integer getApproved() {
		return approved;
	}

	public Date getCreationDate() {
		return creation_date;
	}

	public Date getModifiedDate() {
		return modified_date;
	}

	public Date getLastLoginDate() {
		return lastlogin_date;
	}

	public Date getUpdateDate() {
		return update_date;
	}

	public Integer getMemberCount() {
		return member_count;
	}

	public Integer getViewCount() {
		return view_count;
	}

	public String getLocation() {
		return location;
	}

	public String getImage() {
		return image;
	}

	public String getImageIcon() {
		return image_icon;
	}

	public String getImageProfile() {
		return image_profile;
	}

	public String getImageNormal() {
		return image_normal;
	}

	public String getContentUrl() {
		return content_url;
	}

	public String getCover() {
		return cover;
	}

	public Boolean userExists() {
		return (userId != null);
	}

	public void setUsername(String username) {
    this.username = username;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setDisplayName(String displayname) {
		this.displayname = displayname;
	}

	public void setPhotoId(Integer photo_id) {
		this.photo_id = photo_id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatusDate(Date status_date) {
		this.status_date = status_date;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setlanguage(String language) {
		this.language = language;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public void setSearch(Integer search) {
		this.search = search;
	}

	public void setShowProfileViewers(Integer show_profileviewers) {
		this.show_profileviewers = show_profileviewers;
	}

	public void setShowLevelId(Integer level_id) {
		this.level_id = level_id;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public void setVerified(Integer verified) {
		this.verified = verified;
	}

	public void setApproved(Integer approved) {
		this.approved = approved;
	}

	public void setCreationDate(Date creation_date) {
		this.creation_date = creation_date;
	}

	public void setModifiedDate(Date modified_date) {
		this.modified_date = modified_date;
	}

	public void setLastLoginDate(Date lastlogin_date) {
		this.lastlogin_date = lastlogin_date;
	}

	public void setUpdateDate(Date update_date) {
		this.update_date = update_date;
	}

	public void setMemberCount(Integer member_count) {
		this.member_count = member_count;
	}

	public void setViewCount(Integer view_count) {
		this.view_count = view_count;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setImageIcon(String image_icon) {
		this.image_icon = image_icon;
	}

	public void setImageProfile(String image_profile) {
		this.image_profile = image_profile;
	}

	public void setImageNormal(String image_normal) {
		this.image_normal = image_normal;
	}

	public void setContentUrl(String content_url) {
		this.content_url = content_url;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

}