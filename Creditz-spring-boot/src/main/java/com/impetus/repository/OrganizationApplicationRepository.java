package com.impetus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.model.OrganizationApplicant;

@Repository
public interface OrganizationApplicationRepository extends JpaRepository<OrganizationApplicant, Long>
{
	@Transactional
	@Query(nativeQuery=true, value="SELECT LAST_INSERT_ID()")
	Long getApplicationId();
	
	
}


