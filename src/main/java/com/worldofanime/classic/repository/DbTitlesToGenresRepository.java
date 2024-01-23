package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.DbTitlesToGenres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Set;

public interface DbTitlesToGenresRepository extends PagingAndSortingRepository<DbTitlesToGenres, Integer> {
	public Set<DbTitlesToGenres> findByDbGenreIdAndActive(int db_genre_id, boolean active);
	public Set<DbTitlesToGenres> findByDbTitleIdAndActive(int db_title_id, boolean active);
	public Page<DbTitlesToGenres> findByDbGenreIdAndActive(int db_genre_id, boolean active, Pageable pageable);
}
