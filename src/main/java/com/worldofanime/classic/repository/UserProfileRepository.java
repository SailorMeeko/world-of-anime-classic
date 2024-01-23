package com.worldofanime.classic.repository;

import com.worldofanime.classic.model.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer>, JpaRepository<UserProfile, Integer> {
}
