package com.impetus.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.model.User;

/**
 * Repository to fetch data from User
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * find user by role in particular page size and and number of records
	 * 
	 * @param role
	 * 
	 *   @ return page of type user
	 */
	Page<User> findByRole(String role, Pageable pageable);

	/**
	 * find user by email
	 * 
	 * @param userId user id
	 * 
	 * @return user
	 */

	User findByUserEmail(String userEmail);

	/**
	 * find user by email and password combination
	 * 
	 * @param userEmail
	 * 
	 * @param password
	 */
	@Transactional
	@Modifying
	@Query("UPDATE user u SET u.password=:password where u.userEmail=:userEmail")
	void updatePassword(String userEmail, String password);

}
