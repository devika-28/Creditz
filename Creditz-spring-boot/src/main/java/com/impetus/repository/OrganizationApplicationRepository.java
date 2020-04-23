package com.impetus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.model.OrganizationApplicant;

/**
 * Deal with organization applications stored in database
 */
@Repository
public interface OrganizationApplicationRepository extends JpaRepository<OrganizationApplicant, Long> {
	
	/**
	 * setting the details of organization applicant to insert into the table 
	 * @param applicationStatus application status
	 * 
	 * @return list of organization applicants
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into organizationapplicant ( bankruptcy,age,criminal_record,employee_count,licenseno,loan_amount,loan_tenure,organization_type,pan_card,revenue, application_status,organization_id,user_id,email_status)"
			+ " values (:bankruptcy , :age, :criminalRecord, :employeeCount,:licenseNumber, :loanAmount , :loanTenure,:organizationType,:pancard,:revenue, :applicationStatus, :organizationId, :userId , :emailStatus)", nativeQuery = true)

	void insertApplication(@Param("bankruptcy") int bankruptcy, @Param("age") int age,
			@Param("criminalRecord") int criminalRecord, @Param("employeeCount") int employeeCount,
			@Param("licenseNumber") String licenseNumber, @Param("loanAmount") int loanAmount,
			@Param("loanTenure") int loanTenure, @Param("organizationType") String organizationType,
			@Param("pancard") String pancard, @Param("revenue") long revenue,
			@Param("applicationStatus") String applicationStatus, @Param("organizationId") long organizationId,
			@Param("userId") long userId, @Param("emailStatus") String emailStatus);

	/**
	 * getting last inserted id in the organization applicant table
	 * @return the Long value containing application id
	 */
	@Query(nativeQuery = true, value = "SELECT LAST_INSERT_ID()")
	Long getApplicationId();

	/**
	 * Find the application by email status
	 * 
	 * @param emailStatus email status, whether email is sent or not
	 * 
	 * @return list of organization applicants
	 */
	List<OrganizationApplicant> findByemailStatus(String emailStatus);

	/**
	 * update email status with respect to the application ID
	 * 
	 * @param applicationId application id
	 * 
	 * @param status        status of the application
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE organizationapplicant p SET p.email_status =:status WHERE p.application_id = :applicationId")
	void updateEmailStatus(long applicationId, String status);

	/**
	 * find top 10 creditors from the organization applications.
	 * 
	 * @param applicationStatus application status
	 * 
	 * @return list of organization applicants
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "SELECT *FROM organizationapplicant,cibil_report WHERE organizationapplicant.pan_card=cibil_report.pan_card  AND application_status= :applicationStatus GROUP BY user_id  ORDER BY credit_score DESC LIMIT 10")
	List<OrganizationApplicant> findTopPersonCreditors(String applicationStatus);

	
	
	/**
	 * 
	 * @param userId
	 * @return list of applicant with same userid given in the parameter
	 */
	@Query(nativeQuery = true, value = "Select * from organizationapplicant where user_id=:userId")
	List<OrganizationApplicant> findByUserId(long userId);

	/**
	 * 
	 * @param userId
	 * @return applicant id by user id 
	 */
	Long getApplicationIdByUserId(@Param("userId") Long userId);

}
