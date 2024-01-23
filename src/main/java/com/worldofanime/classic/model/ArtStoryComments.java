package com.worldofanime.classic.model;

import javax.persistence.*;
import com.worldofanime.classic.interfaces.User;
import com.worldofanime.classic.model.LegacyUsers;
import com.worldofanime.classic.SiteUtilities;
import java.util.Date;

@Entity
@Table(name="art_story_comments")
public class ArtStoryComments {

	@Id
	@Column(name="id")
	private int id;

    @Column(name="art_story_id")
    private int storyId;

    @Column(name="chapter_id")
    private int chapterId;
	
    private Integer legacy_user_id;
    private Integer user_id;

    @Column(name="comment" , length = 65535, columnDefinition="TEXT")
    private String comment;    

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifydate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;        

    @OneToOne
    @JoinColumn(name = "legacy_user_id", insertable=false, updatable=false)
    private LegacyUsers legacyUser;

    public ArtStoryComments() {}

    public int getId() {
    	return id;
    }

    public int getStoryId() {
        return storyId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public Integer getLegacyUserId() {
        return legacy_user_id;
    }

    public Integer getUserId() {
        return user_id;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentHTML() {
        return SiteUtilities.GetStringForHTML(getComment());
    }

    public Date getModifyDate() {
        return modifydate;
    }

    public Date getCreateDate() {
        return createdate;
    }    

    public User getLegacyUser() {
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