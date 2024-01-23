package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.DbTitles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DbTitlesRepository extends CrudRepository<DbTitles, Integer>, PagingAndSortingRepository<DbTitles, Integer> {

	@Query("select d from DbTitles d where d.active = 1 order by rand()")
	public Page<DbTitles> findRandomDbTitle(Pageable pageable);

	public DbTitles findById(int id);

	@Query("select d from DbTitles d where d.active = 1 and (d.english_title like %:searchTerm% or d.description like %:searchTerm%)")
	public List<DbTitles> findBySearchTerm(@Param("searchTerm") String searchTerm);

}
