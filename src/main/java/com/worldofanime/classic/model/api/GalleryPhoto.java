package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GalleryPhoto {

	@JsonProperty("photo_id")
	private int photoId;

	@JsonProperty("album_id")
	private int albumId;

	@JsonProperty("title")
	private String title;

	@JsonProperty("description")
	private String description;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("creation_date")
    private Date creationDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("modified_date")
    private Date modifiedDate;    	

    @JsonProperty("order")
    private int order;

    @JsonProperty("owner_type")
    private String ownerType;

	@JsonProperty("owner_id")
	private int ownerId;

	@JsonProperty("file_id")
	private int fileId;

	@JsonProperty("view_count")
	private int viewCount;

	@JsonProperty("comment_count")
	private int commentCount;

	@JsonProperty("like_count")
	private int likeCount;

	@JsonProperty("photo_hide")
	private int photoHide;

	@JsonProperty("rating")
	private int rating;

	@JsonProperty("location")
	private String location;

	@JsonProperty("featured")
	private int featured;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("date_taken")
    private Date dateTaken; 

    @JsonProperty("skip_photo")
    private int skipPhoto;   		

    @JsonProperty("is_like")
    private Boolean isLike;

    // TODO - tags

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

	public GalleryPhoto() { }

	public int getPhotoId() {
		return photoId;
	}

	public int getAlbumId() {
		return albumId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public int getOrder() {
		return order;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public int getFileId() {
		return fileId;
	}

	public int getViewCount() {
		return viewCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public int getPhotoHide() {
		return photoHide;
	}

	public int getRating() {
		return rating;
	}

	public String getLocation() {
		return location;
	}

	public int getFeatured() {
		return featured;
	}

	public Date getDateTaken() {
		return dateTaken;
	}

	public int getSkipPhoto() {
		return skipPhoto;
	}

	public Boolean getIsLike() {
		return isLike;
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

	public String getHoverTitle() {
		return "Added on " + getCreationDate() + "<br>" + getViewCount() + " views<br>" + getCommentCount() + " comments";
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public void setAlbumId(int albumId) {
    	this.albumId = albumId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public void setPhotoHide(int photoHide) {
		this.photoHide = photoHide;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setFeatured(int featured) {
		this.featured = featured;
	}

	public void setDateTaken(Date dateTaken) {
		this.dateTaken = dateTaken;
	}

	public void setSkipPhoto(int skipPhoto) {
		this.skipPhoto = skipPhoto;
	}

	public void setIsLike(Boolean isLike) {
		this.isLike = isLike;
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
		contentUrl = contentUrl.replaceAll("advancedalbums", "albums");				
		this.contentUrl = contentUrl;
	}

}