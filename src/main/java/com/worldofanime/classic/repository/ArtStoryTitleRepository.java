package com.worldofanime.classic.repository;

import org.springframework.data.jpa.repository.Query;
import com.worldofanime.classic.model.ArtStoryTitle;
import com.worldofanime.classic.model.CustomDbTitlesWithFanFiction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import java.util.Set;

public interface ArtStoryTitleRepository extends CrudRepository<ArtStoryTitle, Integer>, PagingAndSortingRepository<ArtStoryTitle, Integer> {
	public Set<ArtStoryTitle> findAllByDbTitleId(int id);

	@Query("select distinct new com.worldofanime.classic.model.CustomDbTitlesWithFanFiction(s.db_title_id as dbTitleId, t.english_title as englishTitle, (select count(*) from ArtStoryTitle where db_title_id = s.db_title_id) as numStories) from ArtStoryTitle s join DbTitles t on s.db_title_id = t.id where s.db_title_id != 0 order by englishTitle")
	public Set<CustomDbTitlesWithFanFiction> findAllFromDbTitlesQuery();

	public Page<ArtStoryTitle> findByDbTitleId(int dbTitleId, Pageable pageable);
}
