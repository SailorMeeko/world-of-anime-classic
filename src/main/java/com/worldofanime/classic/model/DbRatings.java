package com.worldofanime.classic.model;

import javax.persistence.*;
import com.worldofanime.classic.model.LegacyUsers;
import com.worldofanime.classic.interfaces.User;
import com.worldofanime.classic.HTMLUtilities;

@Entity
@Table(name="db_ratings")
public class DbRatings {

	@Id
	@Column(name="id")
	private int id;
	
    @Column(name="db_title_id")
	private int dbTitleId;
	private Integer legacy_user_id;
    private Integer user_id;

    private byte rating;

    @OneToOne
    @JoinColumn(name = "legacy_user_id", insertable=false, updatable=false)
    private LegacyUsers legacyUser;

    public DbRatings() {}

    public int getId() {
    	return id;
    }

    public int getDbTitleId() {
        return dbTitleId;
    }

    public Integer getLegacyUserId() {
        return legacy_user_id;
    }

    public Integer getUserId() {
        return user_id;
    }        

    public byte getRating() {
        return rating;
    }

    public LegacyUsers getLegacyUser() {
        return legacyUser;
    }

    public String getRatingStars() {
        return HTMLUtilities.GenerateRatingStars(getRating());
    }

    public User getUser() {
        // TODO: Once new user table is defined, return a new user if user_id exists
        if (user_id != null) {
            // return getUser();
        }

        // If no new user, return legacy user
        return getLegacyUser();
    }        
}