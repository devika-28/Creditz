package com.impetus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.impetus.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	@Query(nativeQuery=true, value="select organization_id from organization where user_id= :userId")
	Long getOrganizationIdByUserId(@Param("userId") Long userId);
	

}
