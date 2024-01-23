package com.worldofanime.classic.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="db_titles_searches")
public class DbTitlesSearches {

	@Id
	@Column(name="id")
	private int id;

    @Column(name="search_term")
    private String searchTerm;

    @Column(name="num_results")
    private int numResults;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;    

    public DbTitlesSearches() {}

    public int getId() {
    	return id;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public int getNumResults() {
        return numResults;
    }    

    public Date getCreateDate() {
        return createdate;
    }    

    public void setId(int id) {
        this.id = id;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }    

}