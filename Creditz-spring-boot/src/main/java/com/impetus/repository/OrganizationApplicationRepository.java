package com.impetus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.model.OrganizationApplicant;
import com.impetus.model.PersonApplicant;


@Repository
public interface OrganizationApplicationRepository extends JpaRepository<OrganizationApplicant, Long>
{
	@Modifying
	@Transactional
	@Query(	value =  "insert into organizationapplicant ( bankruptcy,age,criminal_record,employee_count,licenseno,loan_amount,loan_tenure,organization_type,pan_card,revenue, application_status,organization_id,user_id,email_status)"
			+ " values (:bankruptcy , :age, :criminalRecord, :employeeCount,:licenseNumber, :loanAmount , :loanTenure,:organizationType,:pancard,:revenue, :applicationStatus, :organizationId, :userId , :emailStatus)", nativeQuery = true)
	
	void insertApplication(@Param("bankruptcy") int bankruptcy,
			@Param("age") int age,
			@Param("criminalRecord") int criminalRecord, 
			@Param("employeeCount") int employeeCount, 
			@Param("licenseNumber")String licenseNumber,
			@Param("loanAmount")int loanAmount,
			@Param("loanTenure") int loanTenure, 
			@Param("organizationType") String organizationType ,
			@Param("pancard") String pancard, 
			@Param("revenue")long revenue, 
    		@Param("applicationStatus") String applicationStatus, 
			@Param("organizationId") long organizationId,
			@Param("userId") long userId,
			@Param("emailStatus") String emailStatus);
	
	
	@Query(nativeQuery=true, value="SELECT LAST_INSERT_ID()")
	Long getApplicationId();
	
	List<OrganizationApplicant> findByemailStatus(String emailStatus);
	
	@Modifying
	@Transactional
    @Query(nativeQuery = true,value="UPDATE organizationapplicant p SET p.email_status =:status WHERE p.application_id = :applicationId")
    void updateEmailStatus(long applicationId, String status);
    
	@Modifying
	@Transactional
	@Query(nativeQuery=true,value="SELECT *FROM organizationapplicant,cibil_report WHERE organizationapplicant.pan_card=cibil_report.pan_card ORDER BY credit_score DESC LIMIT 10") 
    List<OrganizationApplicant> findTopPersonCreditors();
	
	@Query(nativeQuery=true, value="Select * from organizationapplicant where user_id=:userId")
	List<OrganizationApplicant> findByUserId(long userId);

	
	//Long getApplicantIdByUserId(@Param("userId") Long userId);
	Long getApplicationIdByUserId(@Param("userId") Long userId);
	
}


