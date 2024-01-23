package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonalDetails {

	@JsonProperty("About Me")
	private String aboutMe;

   @JsonProperty("Favorite Anime")
   private String favoriteAnime;

   @JsonProperty("Favorite Movies")
   private String favoriteMovies;

  	public PersonalDetails() { }

   public String getAboutMe() {
      return aboutMe;
   }

   public String getFavoriteAnime() {
      return favoriteAnime;
   }

   public String getFavoriteMovies() {
   	return favoriteMovies;
   }
   
   public void setAboutMe(String aboutMe) {
      this.aboutMe = aboutMe;
   }

   public void setFavoriteAnime(String favoriteAnime) {
      this.favoriteAnime = favoriteAnime;
   }

   public void setFavoriteMovies(String favoriteMovies) {
   	this.favoriteMovies = favoriteMovies;
   }

}