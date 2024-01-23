package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.DbGenres;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DbGenresRepository extends CrudRepository<DbGenres, Integer> {
	public DbGenres findByName(String name);
	public List<DbGenres> findAllByOrderByDisplayOrderAsc();
}
