package com.worldofanime.classic.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.io.Serializable;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.worldofanime.classic.SiteUtilities;
import com.worldofanime.classic.interfaces.User;
import com.worldofanime.classic.model.LegacyUsers;

@Entity
@Table(name="db_titles")
public class DbTitles implements Serializable {

	@Id
	@Column(name="id")
	private int id;
	
	private int static_id;

	@Column(nullable = false, columnDefinition = "TINYINT(3)")
	private boolean active;

	private Integer started_by_legacy_user_id;
    private Integer started_by_user_id;
	private int category_id;

    @Column(insertable=false, updatable=false)
    private String english_title;

	@Column(name="english_title")
	private String englishTitle;
	private String japanese_title;

	@Column(name="description" , length = 65535, columnDefinition="TEXT")
    @JsonIgnore
	private String description;

	private short publish_year;
	private short num_episodes;
	private short episode_length;
	private int profile_image_id;

	@Temporal(TemporalType.TIMESTAMP)
    private Date modifydate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "db_titles_to_genres", joinColumns = @JoinColumn(name = "from_title_edit", referencedColumnName = "static_id"), inverseJoinColumns = @JoinColumn(name = "db_genre_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<DbGenres> genres;
    public Set<DbGenres> getGenres() {
        return genres;
    }

    @OneToOne
    @JoinColumn(name = "category_id", insertable=false, updatable=false)
	private DbCategories dbCategory;

	@OneToOne
	@JoinColumn(name = "profile_image_id", insertable=false, updatable=false)
    @JsonIgnore
	private Images profileImage;

    @OneToOne
    @JoinColumn(name = "started_by_legacy_user_id", insertable=false, updatable=false)
    @JsonIgnore
    private LegacyUsers legacyUser;        


    public DbTitles() {}

    public int getId() {
    	return id;
    }

    public int getStaticId() {
    	return static_id;
    }

    public boolean getActive() {
    	return active;
    }

    public Integer getStartedByLegacyUserId() {
        return started_by_legacy_user_id;
    }

    public Integer getStartedByUserId() {
        return started_by_user_id;
    }

    public int getCategoryId() {
    	return category_id;
    }

    public String getEnglishTitle() {
    	return englishTitle;
    }

    public String getJapaneseTitle() {
    	return japanese_title;
    }

    public String getDescription() {
    	return description;
    }

    public String getShortenedDescription() {
        return SiteUtilities.GetShortenedStringForHTML(getDescription());
    }    

    public short getPublishYear() {
    	return publish_year;
    }

    public short getNumEpisodes() {
    	return num_episodes;
    }

    public short getEpisodeLength() {
    	return episode_length;
    }

    public int getProfileImageId() {
    	return profile_image_id;
    }

    public Date getModifyDate() {
    	return modifydate;
    }

    public Date getCreateDate() {
    	return createdate;
    }

    public DbCategories getDbCategory() {
    	return dbCategory;
    }

    public Images getProfileImage() {
    	return profileImage;
    }

    public String getSafeUrl() {
    	return SiteUtilities.GenerateSafeUrl(englishTitle);
    }

    public User getLegacyUser() {
        return legacyUser;
    }

    public User getStartedByUser() {
        // TODO: Once new user table is defined, return a new user if user_id exists
        if (started_by_user_id != null) {
            // return getUser();
        }

        // If no new user, return legacy user
        return getLegacyUser();
    }        

}