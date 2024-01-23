package com.worldofanime.classic.model;

import com.worldofanime.classic.interfaces.User;
import com.worldofanime.classic.model.UserProfile;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="legacy_users")
public class LegacyUsers implements User {

	@Id
	@Column(name="id")
	private int id;
	
	private String username;
	private String email;
    private int user_profile_id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifydate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @OneToOne
    @JoinColumn(name = "user_profile_id", insertable=false, updatable=false)
    private UserProfile userProfile;

    public LegacyUsers() {}

    public int getId() {
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

    public Date getModifyDate() {
        return modifydate;
    }

    public Date getCreateDate() {
        return createdate;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

}