package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.ArtStoryComments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Sort;
import java.util.Set;

public interface ArtStoryCommentsRepository extends CrudRepository<ArtStoryComments, Integer>, PagingAndSortingRepository<ArtStoryComments, Integer> {
	public Set<ArtStoryComments> findAllByChapterId(int id, Sort sort);
}
