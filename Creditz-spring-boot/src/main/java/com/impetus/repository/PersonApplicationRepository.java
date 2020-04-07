package com.impetus.repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.impetus.model.PersonApplicant;

@Repository
public interface PersonApplicationRepository extends JpaRepository<PersonApplicant, Long> {

	@Modifying
	@Transactional
	@Query(	value =  "insert into personapplicant ( pan_card, loan_amount, age, gender, occupation, application_status, criminal_record, bankruptcy, loan_tenure, person_id, user_id, email_Status)"
			+ " values (:pancard , :loanAmount , :age, :gender, :occupation, :applicationStatus, :criminalRecord, :bankruptcy , :loanTenure, :personId , :userId, :emailStatus)", nativeQuery = true)
	
	void insertApplication(@Param("pancard")String pancard, 
							@Param("loanAmount")int loanAmount, 
							@Param("age") int age, 
							@Param("gender") String gender, 
							@Param("occupation") String occupation,
							@Param("applicationStatus") String applicationStatus, 
							@Param("criminalRecord") int criminalRecord, 
							@Param("bankruptcy") int bankruptcy, 
							@Param("loanTenure") int loanTenure, 
							@Param("personId") long personId,
							@Param("userId") long userId, 
							@Param("emailStatus") String emailStatus);
	
	
	
	@Query(nativeQuery=true, value="SELECT LAST_INSERT_ID()")
	Long getApplicationId();

 @Modifying
	 @Transactional
     @Query(nativeQuery = true,value="UPDATE personapplicant p SET p.email_status =:status WHERE p.application_id = :applicationId")
     void updateEmailStatus(long applicationId, String status);
     List<PersonApplicant> findByemailStatus(String emailStatus);
     
     @Modifying
	 @Transactional
	 @Query(nativeQuery=true,value="SELECT *FROM personapplicant,cibil_report WHERE personapplicant.pan_card=cibil_report.pan_card ORDER BY credit_score DESC LIMIT 10") 
     List<PersonApplicant> findTopPersonCreditors();
	
}


