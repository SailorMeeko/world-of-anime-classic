package com.worldofanime.classic.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="logins")
public class Logins {

	@Id
	@Column(name="id")
	private int id;

    @Column(name="user_id")    
    private int userId;

    @Column(name="ip_address")
    private String ipAddress;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    public Logins() {}

    public int getId() {
    	return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Date getCreateDate() {
        return createdate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

}