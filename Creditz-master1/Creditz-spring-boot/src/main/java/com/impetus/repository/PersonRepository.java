package com.impetus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.impetus.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query(nativeQuery=true, value="select person_id from person where user_id= :userId")
	Long getPersonIdByUserId(@Param("userId") Long userId);

}
