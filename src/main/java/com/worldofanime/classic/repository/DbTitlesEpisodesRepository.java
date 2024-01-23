package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.DbTitlesEpisodes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Sort;
import java.util.Set;

public interface DbTitlesEpisodesRepository extends PagingAndSortingRepository<DbTitlesEpisodes, Integer> {
	public Set<DbTitlesEpisodes> findByDbTitleIdAndActive(int db_title_id, boolean active, Sort sort);
	public DbTitlesEpisodes findByDbTitleIdAndEpisodeNumber(int db_title_id, int episode_number);
}
