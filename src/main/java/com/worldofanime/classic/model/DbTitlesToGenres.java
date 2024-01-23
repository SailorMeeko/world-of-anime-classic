package com.worldofanime.classic.model;

import javax.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="db_titles_to_genres")
public class DbTitlesToGenres {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(nullable = false, columnDefinition = "TINYINT(3)")
	private boolean active;

	private int from_title_edit;
 	private int db_title_id;

    @OneToOne
    @JoinColumn(name = "db_title_id", insertable=false, updatable=false)
    @NotFound(action = NotFoundAction.IGNORE)    
    @OrderBy("english_title asc")
	private DbTitles dbTitle;

	@Column(name="db_genre_id")
	private int dbGenreId;

    @OneToOne
    @JoinColumn(name = "db_genre_id", insertable=false, updatable=false)
    private DbGenres dbGenre;

	public DbTitlesToGenres() {}

	public int getId() {
		return id;
	}

    public boolean getActive() {
    	return active;
    }

    public int getFromTitleEdit() {
    	return from_title_edit;
    }

    public int getTitleId() {
    	return db_title_id;
    }

    public int getGenreId() {
    	return dbGenreId;
    }

    public DbTitles getDbTitle() {
    	return dbTitle;
    }

    public DbGenres getDbGenre() {
        return dbGenre;
    }

}
