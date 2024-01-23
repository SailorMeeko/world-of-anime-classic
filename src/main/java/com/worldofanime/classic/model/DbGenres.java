package com.worldofanime.classic.model;

import javax.persistence.*;
import com.worldofanime.classic.SiteUtilities;

@Entity
@Table(name="db_genres")
public class DbGenres {

	@Id
	@Column(name="id")
	private int id;
	
	private String name;

	@Column(name="display_order")
	private int displayOrder;

	public DbGenres() {}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public String getSafeUrl() {
		return SiteUtilities.GenerateSafeUrl(name);
	}

}
