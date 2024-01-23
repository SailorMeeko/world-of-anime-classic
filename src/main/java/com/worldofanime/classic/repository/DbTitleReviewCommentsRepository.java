package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.DbTitleReviewComments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Set;

public interface DbTitleReviewCommentsRepository extends CrudRepository<DbTitleReviewComments, Integer>, PagingAndSortingRepository<DbTitleReviewComments, Integer> {
	public Set<DbTitleReviewComments> findAllByDbTitleReviewId(int id);
}
