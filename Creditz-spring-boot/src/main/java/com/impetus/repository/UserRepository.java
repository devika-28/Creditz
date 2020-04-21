package com.impetus.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Page<User>findByRole(String role, Pageable pageable);

	User findByUserEmail(String userEmail);

	@Transactional
	@Modifying
	@Query("UPDATE user u SET u.password=:password where u.userEmail=:userEmail")
	void updatePassword(String userEmail, String password);

}
