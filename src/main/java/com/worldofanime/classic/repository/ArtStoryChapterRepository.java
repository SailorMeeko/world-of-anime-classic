package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.ArtStoryChapter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Sort;
import java.util.Set;

public interface ArtStoryChapterRepository extends CrudRepository<ArtStoryChapter, Integer>, PagingAndSortingRepository<ArtStoryChapter, Integer> {
	public Set<ArtStoryChapter> findAllByStoryId(int id, Sort sort);
	public ArtStoryChapter findByStoryIdAndChapterNum(int storyId, int chapterNum);
	public Set<ArtStoryChapter> findTop5ByOrderByIdDesc();
	public int countByStoryId(int storyId);
}
