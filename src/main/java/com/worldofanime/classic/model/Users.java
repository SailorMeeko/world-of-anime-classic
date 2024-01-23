package com.worldofanime.classic.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import com.worldofanime.classic.interfaces.User;
import com.worldofanime.classic.model.UserProfile;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
public class Users implements User {

	@Id
	@Column(name="id")
	private Integer id;
	
	private String username;
	private String email;
    private int user_profile_id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "latestactivitydate")
    private Date latestActivityDate;    

    @OneToOne
    @JoinColumn(name = "user_profile_id", insertable=false, updatable=false)
    // Make optional
    private UserProfile userProfile;

    public Users() {}

    public Users(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
    	return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getUserProfileId() {
        return user_profile_id;
    }

    public Date getCreateDate() {
        return createdate;
    }

    public Date getLatestActivityDate() {
        return latestActivityDate;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserProfileId(int userProfileId) {
        this.user_profile_id = userProfileId;
    }

    public void setLatestActivityDate(Date latestActivityDate) {
        this.latestActivityDate = latestActivityDate;
    }
}