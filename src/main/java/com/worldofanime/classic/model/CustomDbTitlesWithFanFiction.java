package com.worldofanime.classic.model;

import org.springframework.data.jpa.repository.*;
import com.worldofanime.classic.SiteUtilities;

public class CustomDbTitlesWithFanFiction {


    private int dbTitleId;
    private String englishTitle;
    private int numStories;

    public CustomDbTitlesWithFanFiction() {}

    public CustomDbTitlesWithFanFiction(int dbTitleId, String englishTitle, long numStories) {
        this.dbTitleId = dbTitleId;
        this.englishTitle = englishTitle;
        this.numStories = (int) numStories;
    }

    public void setDbTitleId(int dbTitleId) {
        this.dbTitleId = dbTitleId;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public void setNumStories(int numStories) {
        this.numStories = numStories;
    }

    public int getDbTitleId() {
        return dbTitleId;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public int getNumStories() {
        return numStories;
    }

    public String getSafeUrl() {
        return SiteUtilities.GenerateSafeUrl(getEnglishTitle());
    }    

}