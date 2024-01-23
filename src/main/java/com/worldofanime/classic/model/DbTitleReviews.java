package com.worldofanime.classic.model;

import javax.persistence.*;
import com.worldofanime.classic.model.LegacyUsers;
import com.worldofanime.classic.SiteUtilities;
import com.worldofanime.classic.interfaces.User;
import java.util.Date;

@Entity
@Table(name="db_title_reviews")
public class DbTitleReviews {

	@Id
	@Column(name="id")
	private int id;
	
    @Column(name="db_title_id")
	private int dbTitleId;
	private Integer legacy_user_id;
    private Integer user_id;

    @Column(name="review" , length = 65535, columnDefinition="TEXT")
    private String review;    

    private byte rating;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifydate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;    

    @OneToOne
    @JoinColumn(name = "legacy_user_id", insertable=false, updatable=false)
    private LegacyUsers legacyUser;

    @OneToOne
    @JoinColumn(name = "db_title_id", insertable=false, updatable=false)
    private DbTitles dbTitle;    

    public DbTitleReviews() {}

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

    public String getReview() {
        return review;
    }

    public String getReviewHTML() {
        return SiteUtilities.GetStringForHTML(getReview());
    }

    public String getShortenedReviewHTML() {
        return SiteUtilities.GetShortenedStringForHTML(getReview());
    }

    public byte getRating() {
        return rating;
    }

    public Date getModifyDate() {
        return modifydate;
    }

    public Date getCreateDate() {
        return createdate;
    }    

    public DbTitles getDbTitle() {
        return dbTitle;
    }    

    public LegacyUsers getLegacyUser() {
        return legacyUser;
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