package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactInformation {

	@JsonProperty("Website")
	private String website;

   @JsonProperty("Twitter")
   private String twitter;

   @JsonProperty("Facebook")
   private String facebook;

  	public ContactInformation() { }

   public String getWebsite() {
      return website;
   }

   public String getTwitter() {
      return twitter;
   }

   public String getFacebook() {
   	return facebook;
   }
   
   public void setWebsite(String website) {
      this.website = website;
   }

   public void setTwitter(String twitter) {
      this.twitter = twitter;
   }

   public void setFacebook(String facebook) {
   	this.facebook = facebook;
   }

}