package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGalleryBody {

	@JsonProperty("totalPhotoCount")
	private int totalPhotoCount;

	@JsonProperty("album")
	private Gallery album;

	@JsonProperty("response")
	private String response;  

	@JsonProperty("canEdit")
	private int canEdit;

	@JsonProperty("albumPhotos")
	private List<GalleryPhoto> photos;  	

	public UserGalleryBody() { }

	public int getTotalPhotoCount() {
		return totalPhotoCount;
	}

	public Gallery getAlbum() {
		return album;
	}

	public String getResponse() {
		return response;
	}

	public int getCanEdit() {
		return canEdit;
	}

	public List<GalleryPhoto> getPhotos() {
		return photos;
	}

	public void setTotalPhotoCount(int totalPhotoCount) {
		this.totalPhotoCount = totalPhotoCount;
	}

	public void setAlbum(Gallery album) {
		this.album = album;
	}

	public void setResponse(String response) {
		this.response = response;
	}  

	public void setCanEdit(int canEdit) {
		this.canEdit = canEdit;
	}

	public void setPhotos(List<GalleryPhoto> photos) {
		this.photos = photos;
	}

}