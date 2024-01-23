package com.worldofanime.classic.model;

import javax.persistence.*;

@Entity
@Table(name="art_story_ratings")
public class ArtStoryRatings {

	@Id
	@Column(name="id")
	private int id;
	
    @Column(name="rating")
	private String ratingName;
    
    private String description;

    private int display_order;

    public ArtStoryRatings() {}

    public int getId() {
    	return id;
    }

    public String getRatingName() {
    	return ratingName;
    }

    public String getDescription() {
        return description;
    }
 
    public int getDisplayOrder() {
        return display_order;
    }

}