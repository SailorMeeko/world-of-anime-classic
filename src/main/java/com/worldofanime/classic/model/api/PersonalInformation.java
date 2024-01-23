package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonalInformation {

	@JsonProperty("Name")
	private String name;

   @JsonProperty("Gender")
   private String gender;

   @JsonProperty("Birthday")
   private String birthday;

  	public PersonalInformation() { }

   public String getName() {
      return name;
   }

   public String getGender() {
      return gender;
   }

   public String getBirthday() {
   	return birthday;
   }
   
   public void setName(String name) {
      this.name = name;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public void setBirthday(String birthday) {
   	this.birthday = birthday;
   }

}