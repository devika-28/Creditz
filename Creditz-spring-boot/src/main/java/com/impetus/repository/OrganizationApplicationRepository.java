package com.impetus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.model.OrganizationApplicant;

@Repository
public interface OrganizationApplicationRepository extends JpaRepository<OrganizationApplicant, Long>
{
	@Modifying
	@Transactional
	@Query(	value =  "insert into organizationapplicant ( bankruptcy,age,criminal_record,employee_count,licenseno,loan_amount,loan_tenure,organization_type,pan_card,revenue, application_status,organization_id,user_id)"
			+ " values (:bankruptcy , :age, :criminalRecord, :employeeCount,:licenseNumber, :loanAmount , :loanTenure,:organizationType,:pancard,:revenue, :applicationStatus, :organizationId, :userId)", nativeQuery = true)
	
	void insertApplication(@Param("bankruptcy") Boolean bankruptcy,
			@Param("age") int age,
			@Param("criminalRecord") Boolean criminalRecord, 
			@Param("employeeCount") int employeeCount, 
			@Param("licenseNumber")String licenseNumber,
			@Param("loanAmount")int loanAmount,
			@Param("loanTenure") int loanTenure, 
			@Param("organizationType") String organizationType ,
			@Param("pancard") String pancard, 
			@Param("revenue")long revenue, 
    		@Param("applicationStatus") String applicationStatus, 
			@Param("organizationId") long organizationId,
			@Param("userId") long userId);
	
	
	@Query(nativeQuery=true, value="SELECT LAST_INSERT_ID()")
	Long getApplicationId();
	
	
}


