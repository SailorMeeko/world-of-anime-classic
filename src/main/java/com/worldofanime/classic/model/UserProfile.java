package com.worldofanime.classic.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_profile")
public class UserProfile {

	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String name;
	private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")
    private boolean show_age;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")
    private boolean show_gallery_to_all;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")
    private boolean show_actions;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")    
    private boolean show_visible;

    @Column(name="about_me" , length = 65535, columnDefinition="TEXT")
    private String aboutMe;      

    private String timezone;
    private String twitter;

    @Column(name="signature" , length = 65535, columnDefinition="TEXT")
    private String signature;

    private String now_watching;
    private String now_reading;
    private String now_playing;
    private String now_doing;

    private Integer profile_image_id;
    private Integer background_profile_image_id;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")
    private boolean scroll_background;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")
    private boolean repeat_x;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")
    private boolean repeat_y;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifydate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @OneToOne
    @JoinColumn(name = "profile_image_id", insertable=false, updatable=false)
    private Images profileImage;

    @OneToOne
    @JoinColumn(name = "background_profile_image_id", insertable=false, updatable=false)
    private Images backgroundProfileImage;        

    public UserProfile() {}

    public int getId() {
    	return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public boolean getShowAge() {
        return show_age;
    }

    public boolean getShowGalleryToAll() {
        return show_gallery_to_all;
    }

    public boolean getShowActions() {
        return show_actions;
    }

    public boolean getShowVisible() {
        return show_visible;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getSignature() {
        return signature;
    }

    public String getNowWatching() {
        return now_watching;
    }

    public String getNowReading() {
        return now_reading;
    }

    public String getNowPlaying() {
        return now_playing;
    }

    public String getNowDoing() {
        return now_doing;
    }

    public Integer getProfileImageId() {
        return profile_image_id;
    }

    public Integer getBackgroundProfileImageId() {
        return background_profile_image_id;
    }

    public boolean getScrollBackground() {
        return scroll_background;
    }

    public boolean getRepeatX() {
        return repeat_x;
    }

    public boolean getRepeatY() {
        return repeat_y;
    }

    public Date getModifyDate() {
        return modifydate;
    }

    public Date getCreateDate() {
        return createdate;
    }

    public Images getProfileImage() {
        return profileImage;
    }


    public void setNowWatching(String nowWatching) {
        this.now_watching = nowWatching;
    }

    public void setNowReading(String nowReading) {
        this.now_reading = nowReading;
    }

    public void setNowPlaying(String nowPlaying) {
        this.now_playing = nowPlaying;
    }

    public void setNowDoing(String nowDoing) {
        this.now_doing = nowDoing;
    }

}