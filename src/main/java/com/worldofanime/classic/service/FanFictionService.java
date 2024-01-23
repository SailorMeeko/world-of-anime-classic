package com.worldofanime.classic.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.worldofanime.classic.model.ArtStoryChapter;
import com.worldofanime.classic.repository.ArtStoryChapterRepository;

@Service
public class FanFictionService {

	@Autowired
    ArtStoryChapterRepository artStoryChapterRepository;

    public int getNumberOfChapters(int storyId) {
    	return artStoryChapterRepository.countByStoryId(storyId);
    }

}