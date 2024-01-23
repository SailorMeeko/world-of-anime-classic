package com.worldofanime.classic;

import org.springframework.beans.factory.annotation.Autowired;
import com.worldofanime.classic.model.DbTitles;
import com.worldofanime.classic.model.DbTitlesEpisodes;
import java.util.HashMap;

public class HTMLUtilities {

	private static final String STAR_ON = "<img src=\"/images/icons/star-on.png\">";
	private static final String STAR_OFF = "<img src=\"/images/icons/star-off.png\">";
	private static final String STAR_HALF = "<img src=\"/images/icons/star-half.png\">";


	public static String GenerateEpisodeList(int id, String urlTitle, HashMap<Integer, DbTitlesEpisodes> episodeMap, DbTitles title) {
		String url =  "/anime/" + id + "/" + urlTitle + "/episodes/";

		StringBuilder EpisodeListHTML = new StringBuilder();

		for (int i = 1; i < title.getNumEpisodes(); i++) { 
			EpisodeListHTML.append("<span class=\"episode_list\">");
			EpisodeListHTML.append(i);
			EpisodeListHTML.append(". ");
			if (episodeMap.containsKey(i)) {
				DbTitlesEpisodes episode = episodeMap.get(i);
				EpisodeListHTML.append("<a href=\"" + url + episode.getEpisodeNumber() + "/" + episode.getSafeUrl() + "\">" + episode.getEnglishTitle() + "</a>");
			} else {
				EpisodeListHTML.append("?");
			}
			EpisodeListHTML.append("</span>\n");
		}

		return EpisodeListHTML.toString();
	}


	public static String GenerateRatingStars(int rating) {
		String ratingStars = "";

		switch (rating) {
            case 0:  ratingStars = STAR_OFF + STAR_OFF + STAR_OFF + STAR_OFF + STAR_OFF;
                     break;
            case 1:  ratingStars = STAR_HALF + STAR_OFF + STAR_OFF + STAR_OFF + STAR_OFF;
                     break;
            case 2:  ratingStars = STAR_ON + STAR_OFF + STAR_OFF + STAR_OFF + STAR_OFF;
                     break;                                          
            case 3:  ratingStars = STAR_ON + STAR_HALF + STAR_OFF + STAR_OFF + STAR_OFF;
                     break;
            case 4:  ratingStars = STAR_ON + STAR_ON + STAR_OFF + STAR_OFF + STAR_OFF;
                     break;
            case 5:  ratingStars = STAR_ON + STAR_ON + STAR_HALF + STAR_OFF + STAR_OFF;
                     break;
            case 6:  ratingStars = STAR_ON + STAR_ON + STAR_ON + STAR_OFF + STAR_OFF;
                     break;
            case 7:  ratingStars = STAR_ON + STAR_ON + STAR_ON + STAR_HALF + STAR_OFF;
                     break;
            case 8:  ratingStars = STAR_ON + STAR_ON + STAR_ON + STAR_ON + STAR_OFF;
                     break;
            case 9:  ratingStars = STAR_ON + STAR_ON + STAR_ON + STAR_ON + STAR_HALF;
                     break;
            case 10: ratingStars = STAR_ON + STAR_ON + STAR_ON + STAR_ON + STAR_ON;
                     break;     
        }                                                                                                    

		return ratingStars;
	}

}