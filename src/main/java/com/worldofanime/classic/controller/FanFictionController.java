package com.worldofanime.classic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.worldofanime.classic.repository.ArtStoryTitleRepository;
import com.worldofanime.classic.repository.ArtStoryChapterRepository;
import com.worldofanime.classic.repository.ArtStoryCommentsRepository;
import com.worldofanime.classic.model.ArtStoryTitle;
import com.worldofanime.classic.model.CustomDbTitlesWithFanFiction;
import com.worldofanime.classic.model.ArtStoryChapter;
import com.worldofanime.classic.model.ArtStoryComments;
import com.worldofanime.classic.service.FanFictionService;
import com.worldofanime.classic.HTMLUtilities;
import java.util.Set;
import java.util.HashMap;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;


@Controller
public class FanFictionController {

	@Autowired
	ArtStoryTitleRepository artStoryTitleRepository;

	@Autowired
	FanFictionService fanFictionService;

	@Autowired
	ArtStoryChapterRepository artStoryChapterRepository;

	@Autowired
	ArtStoryCommentsRepository artStoryCommentsRepository;

	@GetMapping("/artist/fiction")
	public String fanFictionHome(Model model) {

		return "fan_fiction_home";
	}

	@GetMapping("/artist/fiction/browse_fiction_by_title")
	public String fanFictionByDbTitle(Model model) {

		Set<CustomDbTitlesWithFanFiction> fictions = artStoryTitleRepository.findAllFromDbTitlesQuery();
		model.addAttribute("fictions", fictions);

		return "fan_fiction_browse_all_from_db_title";
	}

	@GetMapping("/artist/fiction/browse_fiction_original")
	public String fanFictionOriginal(Model model, Pageable pageable) {

		Page<ArtStoryTitle> page = artStoryTitleRepository.findByDbTitleId(0, PageRequest.of(pageable.getPageNumber(), 25, Sort.by(Sort.Direction.DESC, "createdate")));
		model.addAttribute("page", page);

		model.addAttribute("fanFictionService", fanFictionService);

		return "fan_fiction_browse_all_original";
	}

	@GetMapping("/artist/fiction/view_story/{storyId}/{chapterNum}/{storyTitle}")
	public String fanFictionViewStory(@PathVariable int storyId, @PathVariable int chapterNum, @PathVariable String storyTitle, Model model) {

		ArtStoryChapter chapter = artStoryChapterRepository.findByStoryIdAndChapterNum(storyId, chapterNum);
		Set<ArtStoryComments> comments = artStoryCommentsRepository.findAllByChapterId(chapter.getId(), Sort.by(Sort.Direction.DESC, "createdate"));
		Set<ArtStoryChapter> chapters = artStoryChapterRepository.findAllByStoryId(storyId, Sort.by("chapterNum"));
		model.addAttribute("chapter", chapter);
		model.addAttribute("comments", comments);
		model.addAttribute("chapters", chapters);

		return "fan_fiction_view_story";
	}

}
