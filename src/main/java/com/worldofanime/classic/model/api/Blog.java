package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.worldofanime.classic.SiteUtilities;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Blog {

	@JsonProperty("blog_id")
	private int blogId;

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	@JsonProperty("owner_type")
	private String ownerType;

	@JsonProperty("owner_id")
	private int ownerId;

	@JsonProperty("category_id")
	private int categoryId;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("creation_date")
    private Date creationDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("modified_date")
    private Date modifiedDate;

    @JsonProperty("view_count")
    private int viewCount;

    @JsonProperty("comment_count")
    private int commentCount;

    @JsonProperty("search")
    private int search;

    @JsonProperty("draft")
    private int draft;

    @JsonProperty("category_title")
    private String categoryTitle;

    @JsonProperty("url")
    private String url;

    @JsonProperty("owner_image")
    private String ownerImage;

    @JsonProperty("owner_title")
    private String ownerTitle;

    @JsonProperty("allow_to_view")
    private int allowToView;

	public Blog() { }

	public int getBlogId() {
		return blogId;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public int getSearch() {
		return search;
	}

	public int getDraft() {
		return draft;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public String getUrl() {
		return url;
	}

	public String getOwnerImage() {
		return ownerImage;
	}

	public String getOwnerTitle() {
		return ownerTitle;
	}

	public int getAllowToView() {
		return allowToView;
	}

	public String getShortenedContent() {
		return SiteUtilities.GetShortenedStringForHTML(getBody());
	}

	public void setBlogId(int blogId) {
    	this.blogId = blogId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public void setSearch(int search) {
		this.search = search;
	}

	public void setDraft(int draft) {
		this.draft = draft;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setOwnerImage(String ownerImage) {
		this.ownerImage = ownerImage;
	}

	public void setOwnerTitle(String ownerTitle) {
		this.ownerTitle = ownerTitle;
	}

	public void setAllowToView(int allowToView) {
		this.allowToView = allowToView;
	}

}