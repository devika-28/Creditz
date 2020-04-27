package com.impetus.repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.impetus.model.PersonApplicant;

/** Deal with person applications stored in database. */
@Repository
public interface PersonApplicationRepository extends JpaRepository<PersonApplicant, Long> {

    /** insert person application into database along with the risk status, (after checking the risk). */
    @Modifying
    @Transactional
    @Query(value = "insert into personapplicant ( pan_card, loan_amount, age, gender, occupation, application_status, criminal_record, bankruptcy, loan_tenure, person_id, user_id, email_Status)"
            + " values (:pancard , :loanAmount , :age, :gender, :occupation, :applicationStatus, :criminalRecord, :bankruptcy , :loanTenure, :personId , :userId, :emailStatus)",
            nativeQuery = true)

    void insertApplication(@Param("pancard") String pancard, @Param("loanAmount") int loanAmount, @Param("age") int age,
            @Param("gender") String gender, @Param("occupation") String occupation, @Param("applicationStatus") String applicationStatus,
            @Param("criminalRecord") int criminalRecord, @Param("bankruptcy") int bankruptcy, @Param("loanTenure") int loanTenure,
            @Param("personId") long personId, @Param("userId") long userId, @Param("emailStatus") String emailStatus);

    /** fetch the last application AUTO-GENERATED id.
     * @return application ID */
    @Query(nativeQuery = true, value = "SELECT LAST_INSERT_ID()")
    Long getApplicationId();

    /** fetch application from database, based on their userID.
     * 
     * @param userId
     *            user id 
     *            @return person application based on user ID*/
    @Query(nativeQuery = true, value = "Select * from personapplicant where user_id=:userId and email_status=\"True\"\r\n" + "")
    List<PersonApplicant> findByUserId(long userId);

    /** update email status with respect to the application ID.
     * 
     * @param applicationId
     *            application id
     * @param status
     *            status of the application */
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE personapplicant p SET p.email_status =:status WHERE p.application_id = :applicationId")
    void updateEmailStatus(long applicationId, String status);

    /** Find the application by email status.
     * 
     * @param emailStatus
     *            email status, whether email is sent or not
     * @return list of person applicants */
    List<PersonApplicant> findByemailStatus(String emailStatus);

    /** find top 10 creditors from the application.
     * 
     * @param applicationStatus
     *            application status
     * @return list of person applicants */
    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "SELECT*FROM personapplicant,cibil_report WHERE personapplicant.pan_card=cibil_report.pan_card AND application_status= :applicationStatus GROUP BY user_id  ORDER BY credit_score DESC LIMIT 10")
    List<PersonApplicant> findTopPersonCreditors(String applicationStatus);
}