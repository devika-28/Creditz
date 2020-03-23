package com.impetus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.impetus.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User , Long>{

	@Query("SELECT l FROM user l WHERE l.userEmail = :email")
	User findByUserEmail (String email);
	
}
