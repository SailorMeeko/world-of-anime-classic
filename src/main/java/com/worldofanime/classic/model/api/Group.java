package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {

	@JsonProperty("group_id")
	private int groupId;

   @JsonProperty("user_id")
   private int userId;

   @JsonProperty("title")
   private String title;

   @JsonProperty("description")
   private String description;

   @JsonProperty("category_id")
   private int categoryId;

   @JsonProperty("search")
   private int search;

   @JsonProperty("invite")
   private int invite;

   @JsonProperty("approval")
   private int approval;

   @JsonProperty("photo_id")
   private int photoId;

   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   @JsonProperty("creation_date")
   private Date creationDate;

   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   @JsonProperty("modified_date")
   private Date modifiedDate;     

   @JsonProperty("member_count")
   private int memberCount;

   @JsonProperty("view_count")
   private int viewCount;

   @JsonProperty("location")
   private String location;

   @JsonProperty("image")
   private String image;

   @JsonProperty("image_normal")
   private String imageNormal;

   @JsonProperty("image_profile")
   private String imageProfile;

   @JsonProperty("image_icon")
   private String imageIcon;

   @JsonProperty("content_url")
   private String contentUrl;

   @JsonProperty("owner_title")
   private String ownerTitle;

   @JsonProperty("allow_to_view")
   private int allowToView;

  	public Group() { }

   public int getGroupId() {
      return groupId;
   }

   public int getUserId() {
      return userId;
   }

   public String getTitle() {
   	return title;
   }

   public String getDescription() {
      return description;
   }

   public int getCategoryId() {
      return categoryId;
   }

   public int getSearch() {
      return search;
   }

   public int getInvite() {
      return invite;
   }

   public int getApproval() {
      return approval;
   }

   public int getPhotoId() {
      return photoId;
   }

   public Date getCreationDate() {
      return creationDate;
   }

   public Date getModifiedDate() {
      return modifiedDate;
   }

   public int getMemberCount() {
      return memberCount;
   }

   public int getViewCount() {
      return viewCount;
   }
   
   public String getLocation() {
      return location;
   }

   public String getImage() {
      return image;
   }

   public String getImageNormal() {
      return imageNormal;
   }

   public String getImageProfile() {
      return imageProfile;
   }

   public String getImageIcon() {
      return imageIcon;
   }

   public String getContentUrl() {
      return contentUrl;
   }

   public String getOwnerTitle() {
      return ownerTitle;
   }

   public int getAllowToView() {
      return allowToView;
   }

   public void setGroupId(int groupId) {
      this.groupId = groupId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }

   public void setTitle(String title) {
   	this.title = title;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public void setCategoryId(int categoryId) {
      this.categoryId = categoryId;
   }

   public void setSearch(int search) {
      this.search = search;
   }

   public void setInvite(int invite) {
      this.invite = invite;
   }

   public void setApproval(int approval) {
      this.approval = approval;
   }

   public void setPhotoId(int photoId) {
      this.photoId = photoId;
   }

   public void setCreationDate(Date creationDate) {
      this.creationDate = creationDate;
   }

   public void setModifiedDate(Date modifiedDate) {
      this.modifiedDate = modifiedDate;
   }

   public void setMemberCount(int memberCount) {
      this.memberCount = memberCount;
   }

   public void setViewCount(int viewCount) {
      this.viewCount = viewCount;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public void setImageNormal(String imageNormal) {
      this.imageNormal = imageNormal;
   }

   public void setImageProfile(String imageProfile) {
      this.imageProfile = imageProfile;
   }

   public void setImageIcon(String imageIcon) {
      this.imageIcon = imageIcon;
   }

   public void setContentUrl(String contentUrl) {
      this.contentUrl = contentUrl;
   }

   public void setOwnerTitle(String ownerTitle) {
      this.ownerTitle = ownerTitle;
   }

   public void setAllowToView(int allowToView) {
      this.allowToView = allowToView;
   }

}