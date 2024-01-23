package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldofanime.classic.model.api.PersonalInformation;
import com.worldofanime.classic.model.api.ContactInformation;
import com.worldofanime.classic.model.api.PersonalDetails;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoBody {

  @JsonProperty("Personal Information")
  private PersonalInformation personalInformation;  

  @JsonProperty("Contact Information")
  private ContactInformation contactInformation;

  @JsonProperty("Personal Details")
  private PersonalDetails personalDetails;

  public UserInfoBody() { }

  public PersonalInformation getPersonalInformation() {
   	return personalInformation;
  }

  public ContactInformation getContactInformation() {
    return contactInformation;
  }

  public PersonalDetails getPersonalDetails() {
    return personalDetails;
  }

  public void setPersonalInformation(PersonalInformation personalInformation) {
   	this.personalInformation = personalInformation;
  }

  public void setContactInformation(ContactInformation contactInformation) {
    this.contactInformation = contactInformation;
  }

  public void setPersonalDetails(PersonalDetails personalDetails) {
    this.personalDetails = personalDetails;
  }

}