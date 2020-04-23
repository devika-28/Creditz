package com.impetus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.impetus.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	/**
	 * find person id by user id
	 * 
	 * @param userId user id
	 */
	@Query(nativeQuery = true, value = "select person_id from person where user_id= :userId")
	Long getPersonIdByUserId(@Param("userId") Long userId);

	/**
	 * find person by user id
	 * 
	 * @param userId user id
	 */
	@Query(nativeQuery = true, value = " Select * from person where user_id=:userId")
	Person findPersonByUserId(Long userId);
}
