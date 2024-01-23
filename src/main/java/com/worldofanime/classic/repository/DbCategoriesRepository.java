package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.DbCategories;
import org.springframework.data.repository.CrudRepository;

public interface DbCategoriesRepository extends CrudRepository<DbCategories, Integer> {
}
