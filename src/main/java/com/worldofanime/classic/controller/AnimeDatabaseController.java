package com.worldofanime.classic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import java.lang.*;
import java.text.DecimalFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import com.worldofanime.classic.repository.DbGenresRepository;
import com.worldofanime.classic.repository.DbTitlesToGenresRepository;
import com.worldofanime.classic.repository.DbTitlesEpisodesRepository;
import com.worldofanime.classic.repository.DbTitlesRepository;
import com.worldofanime.classic.repository.DbRatingsRepository;
import com.worldofanime.classic.repository.DbTitleReviewsRepository;
import com.worldofanime.classic.repository.DbTitleReviewCommentsRepository;
import com.worldofanime.classic.repository.ArtStoryTitleRepository;
import com.worldofanime.classic.repository.DbTitlesSearchesRepository;
import com.worldofanime.classic.model.DbGenres;
import com.worldofanime.classic.model.DbTitlesToGenres;
import com.worldofanime.classic.model.DbTitles;
import com.worldofanime.classic.model.DbTitlesEpisodes;
import com.worldofanime.classic.model.DbTitlesSearches;
import com.worldofanime.classic.model.DbRatings;
import com.worldofanime.classic.model.DbTitleReviews;
import com.worldofanime.classic.model.DbTitleReviewComments;
import com.worldofanime.classic.model.ArtStoryTitle;
import com.worldofanime.classic.service.FanFictionService;
import com.worldofanime.classic.HTMLUtilities;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;

@Controller
public class AnimeDatabaseController {

	@Autowired
	DbGenresRepository dbGenresRepository;

	@Autowired
	DbTitlesToGenresRepository dbTitlesToGenresRepository;	

	@Autowired
	DbTitlesRepository dbTitlesRepository;

	@Autowired
	DbTitlesEpisodesRepository dbTitlesEpisodesRepository;

	@Autowired
	DbRatingsRepository dbRatingsRepository;

	@Autowired
	DbTitleReviewsRepository dbTitleReviewsRepository;

	@Autowired
	DbTitleReviewCommentsRepository dbTitleReviewCommentsRepository;

	@Autowired
	ArtStoryTitleRepository artStoryTitleRepository;

	@Autowired
	DbTitlesSearchesRepository dbTitlesSearchesRepository;

	@Autowired
	FanFictionService fanFictionService;

    private static final Logger logger = LoggerFactory.getLogger(AnimeDatabaseController.class);   	

	@GetMapping("/anime")
	public String animeHome(Model model) {
		model.addAttribute("dbGenres", dbGenresRepository.findAllByOrderByDisplayOrderAsc());
		return "anime_database_home";
	}

	@PostMapping("/anime/search")
	public ResponseEntity<?> search(@RequestParam("searchString") String searchString) {

		ObjectMapper mapper = new ObjectMapper();

		List<DbTitles> titles = dbTitlesRepository.findBySearchTerm(searchString);
		recordSearch(searchString, titles.size());

		String jsonString = "N";

		try {
			jsonString = mapper.writeValueAsString(titles);
		} catch (Exception e) {
			jsonString = "N";
		}

		if (titles.size() == 0) {
			jsonString = "N";
		}

		return ResponseEntity.ok(jsonString);
	}		

	@GetMapping("/anime/browse/genre/{genre}")
	public String browseByGenre(@PathVariable String genre, Model model, Pageable pageable) {
		model.addAttribute("url", "/anime/browse/genre/" + genre);
		model.addAttribute("genre", genre);

		DbGenres genres = dbGenresRepository.findByName(genre);
		model.addAttribute("genres", genres);

		Page<DbTitlesToGenres> page = dbTitlesToGenresRepository.findByDbGenreIdAndActive(genres.getId(), true, PageRequest.of(pageable.getPageNumber(), 35, Sort.by("dbTitle_englishTitle")));
		model.addAttribute("page", page);


		return "anime_database_browse";
	}

	@GetMapping("/anime/{id}/{urlTitle}")
	public String animeTitle(@PathVariable int id, @PathVariable String urlTitle, Model model) {

		setCommonAnimeDatabaseElements(id, urlTitle, "isAnimePageTypeMainTitle", model);
		return "anime_title";
	}

	@GetMapping("/anime/{id}/{urlTitle}/episodes")
	public String animeTitleEpisodeList(@PathVariable int id, @PathVariable String urlTitle, Model model) {
	
		Set<DbTitlesEpisodes> episodes = dbTitlesEpisodesRepository.findByDbTitleIdAndActive(id, true, Sort.by("episodeNumber"));
		HashMap<Integer, DbTitlesEpisodes> episodeMap = new HashMap<Integer, DbTitlesEpisodes>();

		for (DbTitlesEpisodes episode : episodes) {
    		episodeMap.put(episode.getEpisodeNumber(), episode);
		}

		DbTitles title = dbTitlesRepository.findById(id);
		String episodeListHTML = HTMLUtilities.GenerateEpisodeList(id, urlTitle, episodeMap, title);

		model.addAttribute("episodeListHTML", episodeListHTML);

		setCommonAnimeDatabaseElements(id, urlTitle, "isAnimePageTypeEpisodes", model);
		return "anime_title_episode_list";
	}

	@GetMapping("/anime/{id}/{urlTitle}/episodes/{episodeId}/{episodeTitle}")
	public String animeTitleEpisodeList(@PathVariable int id, @PathVariable String urlTitle, @PathVariable int episodeId, @PathVariable String episodeTitle, Model model) {
	
		DbTitlesEpisodes episode = dbTitlesEpisodesRepository.findByDbTitleIdAndEpisodeNumber(id, episodeId);

		model.addAttribute("episode", episode);

		setCommonAnimeDatabaseElements(id, urlTitle, "isAnimePageTypeEpisodes", model);
		return "anime_title_episode";
	}

	@GetMapping("/anime/{id}/{urlTitle}/ratings")
	public String animeTitleRatings(@PathVariable int id, @PathVariable String urlTitle, Model model) {
	
		setCommonAnimeDatabaseElements(id, urlTitle, "isAnimePageTypeRatings", model);
		return "anime_title_ratings";
	}

	@GetMapping("/anime/{id}/{urlTitle}/reviews")
	public String animeTitleReviews(@PathVariable int id, @PathVariable String urlTitle, Model model) {
	
		Set<DbTitleReviews> reviews = dbTitleReviewsRepository.findAllByDbTitleId(id);

		model.addAttribute("reviews", reviews);

		setCommonAnimeDatabaseElements(id, urlTitle, "isAnimePageTypeReviews", model);
		return "anime_title_reviews";
	}

	@GetMapping("/anime/{id}/{urlTitle}/review/{reviewId}")
	public String animeTitleReviews(@PathVariable int id, @PathVariable String urlTitle, @PathVariable int reviewId, Model model) {
	
		DbTitleReviews review = dbTitleReviewsRepository.findById(reviewId).get();
		model.addAttribute("review", review);

		Set<DbTitleReviewComments> comments = dbTitleReviewCommentsRepository.findAllByDbTitleReviewId(reviewId);
		model.addAttribute("comments", comments);
		
		setCommonAnimeDatabaseElements(id, urlTitle, "isAnimePageTypeReviews", model);
		return "anime_title_review";
	}	

	@GetMapping("/anime/{id}/{urlTitle}/fan_fiction")
	public String animeTitleFanFiction(@PathVariable int id, @PathVariable String urlTitle, Model model) {

		model.addAttribute("fanFictionService", fanFictionService);
		Set<ArtStoryTitle> fictions = artStoryTitleRepository.findAllByDbTitleId(id);
		model.addAttribute("fictions", fictions);

		setCommonAnimeDatabaseElements(id, urlTitle, "isAnimePageTypeFanFiction", model);
		return "anime_title_fan_fiction";
	}					

	@GetMapping("/anime/{id}/{urlTitle}/store")
	public String animeTitleStore(@PathVariable int id, @PathVariable String urlTitle, Model model) {

		setCommonAnimeDatabaseElements(id, urlTitle, "isAnimePageTypeAnimeStore", model);
		return "anime_title_store";
	}

	private void recordSearch(String searchTerm, int numResults) {
     	DbTitlesSearches search = new DbTitlesSearches();

     	search.setSearchTerm(searchTerm);
     	search.setNumResults(numResults);
     	dbTitlesSearchesRepository.save(search);
	}

	private void setCommonAnimeDatabaseElements(int id, String urlTitle, String pageType, Model model) {
		model.addAttribute("url", "/anime/" + id + "/" + urlTitle);
		model.addAttribute(pageType, true);

		DbTitles title = dbTitlesRepository.findById(id);
		Set<DbTitlesToGenres> titlesToGenres = dbTitlesToGenresRepository.findByDbTitleIdAndActive(id, true);

		Set<DbRatings> ratings = dbRatingsRepository.findAllByDbTitleId(id);
		Set<DbTitleReviews> reviews = dbTitleReviewsRepository.findAllByDbTitleId(id);

		String averageRatingsText = getAverageRatingsText(ratings, reviews);

		model.addAttribute("title", title);
		model.addAttribute("titlesToGenres", titlesToGenres);
		model.addAttribute("ratings", ratings);
		model.addAttribute("averageRatingsText", averageRatingsText);
	}

	private String getAverageRatingsText(Set<DbRatings> ratings, Set<DbTitleReviews> reviews) {
		int numOfRatings = ratings.size() + reviews.size();

		double total = ratings.stream().map(x -> (int) x.getRating()).reduce(0, Integer::sum) + 
		               reviews.stream().map(x -> (int) x.getRating()).reduce(0, Integer::sum);

		double average = total / numOfRatings;
		DecimalFormat df = new DecimalFormat("#.00");

		String averageRatingsText = df.format(average) + " out of 10; based on " + numOfRatings + " ratings";

		return averageRatingsText;
	}
}