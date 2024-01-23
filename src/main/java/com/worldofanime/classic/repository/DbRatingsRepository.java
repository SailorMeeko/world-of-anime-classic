package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.DbRatings;
import org.springframework.data.repository.CrudRepository;
import java.util.Set;

public interface DbRatingsRepository extends CrudRepository<DbRatings, Integer> {
	public Set<DbRatings> findAllByDbTitleId(int id);
}
