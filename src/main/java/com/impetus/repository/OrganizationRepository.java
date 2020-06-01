package com.impetus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.impetus.model.Organization;

/** Repository to fetch data from organization. */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	/**
	 * find organization by user id.
	 * 
	 * @param userId user id
	 * @return userId
	 */
	@Query(nativeQuery = true, value = "select organization_id from organization where user_id= :userId")
	Long getOrganizationIdByUserId(@Param("userId") Long userId);

	/**
	 * find organization by user id.
	 * 
	 * @param userId user id
	 * @return Organization
	 */
	@Query(nativeQuery = true, value = " Select * from Organization where user_id=:userId")
	Organization findOrganizationByUserId(Long userId);
}
