package com.worldofanime.classic.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="images")
public class Images {

	@Id
	@Column(name="id")
	private int id;
	
	private int user_id;

	@Column(nullable = false, columnDefinition = "TINYINT(3)")
	private boolean is_s3;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")
    private boolean is_deleted;

    @Column(nullable = false, columnDefinition = "TINYINT(3)")
    private boolean is_appropriate;

	private String filedir;
	private String filename;
    private String filetype;
    private int filesize;
    private int height;
    private int width;

	@Temporal(TemporalType.TIMESTAMP)
    private Date modifydate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    public Images() {}

    public int getId() {
    	return id;
    }

    public int getUserId() {
    	return user_id;
    }

    public boolean getIsS3() {
    	return is_s3;
    }

    public boolean getIsDeleted() {
        return is_deleted;
    }

    public boolean getIsAppropriate() {
        return is_appropriate;
    }

    public String getFiledir() {
    	return filedir;
    }

    public String getFilename() {
    	return filename;
    }

    public String getFiletype() {
    	return filetype;
    }

    public int getFilesize() {
    	return filesize;
    }

    public int getHeight() {
    	return height;
    }

    public int getWidth() {
    	return width;
    }

    public Date getModifyDate() {
    	return modifydate;
    }

    public Date getCreateDate() {
    	return createdate;
    }

    public String getSmallUrl() {
        return getUrl("small");
    }

    public String getThumbUrl() {
        return getUrl("thumb");
    }

    private String getUrl(String size) {
        String filedir = getFiledir();

        if (size.equals("small")) {
            filedir = filedir.replace("/u", "/t175");
        }

        if (size.equals("thumb")) {
            filedir = filedir.replace("/u", "/t80");
        }

        StringBuilder url = new StringBuilder();
        url.append("http://");
        url.append(filedir);
        url.append("/");
        url.append(getFilename());

        return url.toString();
    }

}