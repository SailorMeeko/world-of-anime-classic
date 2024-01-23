package com.worldofanime.classic.model;

import javax.persistence.*;

@Entity
@Table(name="db_categories")
public class DbCategories {

	@Id
	@Column(name="id")
	private int id;
	
	private String name;

	@Column(name="display_order")
	private int displayOrder;

	public DbCategories() {}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

}
