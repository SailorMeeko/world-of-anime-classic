package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Gallery {

	@JsonProperty("album_id")
	private int albumId;

	@JsonProperty("photo_id")
	private int photoId;

	@JsonProperty("title")
	private String title;

	@JsonProperty("description")
	private String description;

	@JsonProperty("owner_id")
	private int ownerId;

	@JsonProperty("view_count")
	private int viewCount;

	@JsonProperty("comment_count")
	private int commentCount;

	@JsonProperty("rating")
	private int rating;

	@JsonProperty("location")
	private String location;

	@JsonProperty("like_count")
	private int likeCount;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("creation_date")
    private Date creationDate;

    @JsonProperty("category_id")
    private int categoryId;

    @JsonProperty("photos_count")
    private int photosCount;

    @JsonProperty("search")
    private int search;

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

    @JsonProperty("is_like")
    private Boolean isLike;

    @JsonProperty("allow_to_view")
    private int allowToView;

    @JsonProperty("owner_title")
    private String ownerTitle;

    @JsonProperty("photo_count")
    private int photoCount;

	public Gallery() { }

	public int getAlbumId() {
		return albumId;
	}

	public int getPhotoId() {
		return photoId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public int getRating() {
		return rating;
	}

	public String getLocation() {
		return location;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public int getPhotosCount() {
		return photosCount;
	}

	public int getSearch() {
		return search;
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

	public Boolean getIsLike() {
		return isLike;
	}

	public int getAllowToView() {
		return allowToView;
	}

	public String getOwnerTitle() {
		return ownerTitle;
	}

	public int getPhotoCount() {
		return photoCount;
	}

	public void setAlbumId(int albumId) {
    	this.albumId = albumId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setPhotosCount(int photosCount) {
		this.photosCount = photosCount;
	}

	public void setSearch(int search) {
		this.search = search;
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

	public void setIsLike(Boolean isLike) {
		this.isLike = isLike;
	}

	public void setAllowToView(int allowToView) {
		this.allowToView = allowToView;
	}

	public void setOwnerTitle(String ownerTitle) {
		this.ownerTitle = ownerTitle;
	}

	public void setPhotoCount(int photoCount) {
		this.photoCount = photoCount;
	}
}