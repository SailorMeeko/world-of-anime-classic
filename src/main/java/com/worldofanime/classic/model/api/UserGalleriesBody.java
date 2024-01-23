package com.worldofanime.classic.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGalleriesBody {

  @JsonProperty("response")
  private List<Gallery> galleries;  

  public UserGalleriesBody() { }

  public List<Gallery> getGalleries() {
    return galleries;
  }  

  public void setGalleries(List<Gallery> galleries) {
  this.galleries = galleries;
  }  

}