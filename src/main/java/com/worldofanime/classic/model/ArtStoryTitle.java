package com.worldofanime.classic.model;

import javax.persistence.*;
import com.worldofanime.classic.SiteUtilities;
import com.worldofanime.classic.interfaces.User;
import com.worldofanime.classic.model.LegacyUsers;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="art_story_title")
public class ArtStoryTitle {

	@Id
	@Column(name="id")
	private int id;
	
	private Integer started_by_legacy_user_id;
    private Integer started_by_user_id;

    @Column(insertable=false, updatable=false)
    private int db_title_id;
	
    @Column(name="db_title_id")
    private int dbTitleId;

    private int rating_id;
    private String title;

    @Column(name="description" , length = 65535, columnDefinition="TEXT")
    private String description;    

    private byte story_mode;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")
    private boolean publish;

	@Temporal(TemporalType.TIMESTAMP)
    private Date modifydate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @OneToOne
    @JoinColumn(name = "rating_id", insertable=false, updatable=false)
    private ArtStoryRatings rating;

    @OneToOne
    @JoinColumn(name = "started_by_legacy_user_id", insertable=false, updatable=false)
    private LegacyUsers legacyUser;    

    public ArtStoryTitle() {}

    public int getId() {
    	return id;
    }

    public Integer getStartedByLegacyUserId() {
    	return started_by_legacy_user_id;
    }

    public Integer getStartedByUserId() {
        return started_by_user_id;
    }

    public int getDbTitleId() {
    	return dbTitleId;
    }

    public int getRatingId() {
        return rating_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionHTML() {
        return SiteUtilities.GetStringForHTML(getDescription());
    }    

    public byte getStoryMode() {
        return story_mode;
    }

    public boolean getPublish() {
        return publish;
    }

    public Date getModifyDate() {
    	return modifydate;
    }

    public Date getCreateDate() {
    	return createdate;
    }

    public String getSafeUrl() {
        return SiteUtilities.GenerateSafeUrl(title);
    }    

    public ArtStoryRatings getRating() {
        return rating;
    }

    public String getRatingName() {
        return getRating().getRatingName();
    }

    public User getLegacyUser() {
        return legacyUser;
    }

    public String getStoryUrl() {
        return "/artist/fiction/view_story/" + Integer.toString(getId()) + "/1/" + getSafeUrl();
    }

    public User getUser() {
        // TODO: Once new user table is defined, return a new user if user_id exists
        if (started_by_user_id != null) {
            // return getUser();
        }

        // If no new user, return legacy user
        return getLegacyUser();
    }    

}