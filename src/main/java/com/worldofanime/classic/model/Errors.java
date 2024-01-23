package com.worldofanime.classic.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="errors")
public class Errors {

	@Id
	@Column(name="id")
	private int id;
	
    private Integer user_id;

    @Column(name="error" , length = 65535, columnDefinition="TEXT")
    private String errorText;

    @Column(name="user_agent" , length = 65535, columnDefinition="TEXT")
    private String userAgent;

    private String referer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    public Errors() {}

    public int getId() {
    	return id;
    }

    public Integer getUserId() {
        return user_id;
    }

    public String getError() {
    	return errorText;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getReferer() {
        return referer;
    }

    public Date getCreateDate() {
    	return createdate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(Integer id) {
        this.user_id = id;
    }

    public void setError(String error) {
        this.errorText = error;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

}