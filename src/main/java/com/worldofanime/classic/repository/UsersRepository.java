package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Date;

public interface UsersRepository extends CrudRepository<Users, Integer>, JpaRepository<Users, Integer> {
	public Users findById(int id);

	@Transactional
	public List<Users> findByLatestActivityDateAfter(Date latestActivityDate);
}
