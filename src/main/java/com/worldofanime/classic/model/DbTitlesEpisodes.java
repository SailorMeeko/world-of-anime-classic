package com.worldofanime.classic.model;

import javax.persistence.*;
import java.util.Date;
import com.worldofanime.classic.SiteUtilities;

@Entity
@Table(name="db_titles_episodes")
public class DbTitlesEpisodes {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(nullable = false, columnDefinition = "TINYINT(3)")
	private boolean active;

	private int added_by_user_id;
	
    @Column(name="db_title_id")
    private int dbTitleId;

    @Column(name="episode_number")
    private int episodeNumber;

	@Column(name="english_title")
	private String englishTitle;

    @Column(name="japanese_title")    
	private String japaneseTitle;

    @Temporal(TemporalType.TIMESTAMP)
    private Date original_airdate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date english_airdate;    

    private int length;

	@Column(name="description" , length = 65535, columnDefinition="TEXT")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
    private Date modifydate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    public DbTitlesEpisodes() {}

    public int getId() {
    	return id;
    }

    public boolean getActive() {
    	return active;
    }

    public int getAddedByUserId() {
    	return added_by_user_id;
    }

    public int getDbTitleId() {
    	return dbTitleId;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public String getEnglishTitle() {
    	return englishTitle;
    }

    public String getJapaneseTitle() {
    	return japaneseTitle;
    }

    public Date getOriginalAirdate() {
        return original_airdate;
    }

    public Date getEnglishAirdate() {
        return english_airdate;
    }    

    public int getLength() {
    	return length;
    }

    public String getDescription() {
        return description;
    }

    public Date getModifyDate() {
    	return modifydate;
    }

    public Date getCreateDate() {
    	return createdate;
    }

    public String getSafeUrl() {
        return SiteUtilities.GenerateSafeUrl(englishTitle);
    }    

}