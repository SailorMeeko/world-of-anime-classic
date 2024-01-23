package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.DbTitleReviews;
import org.springframework.data.repository.CrudRepository;
import java.util.Set;

public interface DbTitleReviewsRepository extends CrudRepository<DbTitleReviews, Integer> {
	public Set<DbTitleReviews> findAllByDbTitleId(int id);
	public DbTitleReviews findFirstByOrderByIdDesc();
}
