package com.worldofanime.classic.model;

import javax.persistence.*;
import com.worldofanime.classic.SiteUtilities;
import com.worldofanime.classic.model.ArtStoryTitle;
import com.worldofanime.classic.interfaces.User;
import com.worldofanime.classic.model.LegacyUsers;
import java.util.Date;

@Entity
@Table(name="art_story_chapter")
public class ArtStoryChapter {

	@Id
	@Column(name="id")
	private int id;
	
    @Column(name="story_id")
    private int storyId;

	private Integer legacy_user_id;
    private Integer user_id;

    @Column(name="chapter_num")
    private int chapterNum;

    private String chapter_title;

    @Column(name="chapter_content" , length = 65535, columnDefinition="TEXT")
    private String chapterContent;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")
    private boolean publish;

	@Temporal(TemporalType.TIMESTAMP)
    private Date modifydate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @OneToOne
    @JoinColumn(name = "legacy_user_id", insertable=false, updatable=false)
    private LegacyUsers legacyUser;

    @OneToOne
    @JoinColumn(name = "story_id", insertable=false, updatable=false)
    private ArtStoryTitle story;

    public ArtStoryChapter() {}

    public int getId() {
    	return id;
    }

    public int getStoryId() {
        return storyId;
    }

    public Integer getLegacyUserId() {
    	return legacy_user_id;
    }

    public Integer getUserId() {
        return user_id;
    }

    public int getChapterNum() {
    	return chapterNum;
    }

    public String getChapterTitle() {
        return chapter_title;
    }

    public String getChapterContent() {
        return chapterContent;
    }

    public String getChapterContentHTML() {
        return SiteUtilities.GetStringForHTML(getChapterContent());
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


    public User getLegacyUser() {
        return legacyUser;
    }

    public ArtStoryTitle getStory() {
        return story;
    }

    public String getChapterUrl() {
        return "/artist/fiction/view_story/" + Integer.toString(getStoryId()) + "/" + Integer.toString(getChapterNum()) + "/" + getStory().getSafeUrl();
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