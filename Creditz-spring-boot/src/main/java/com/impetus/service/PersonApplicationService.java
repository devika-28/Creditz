package com.impetus.service;

import java.util.Map;
import java.util.List;

import org.springframework.stereotype.Service;

import com.impetus.model.PersonApplicant;

@Service
public interface PersonApplicationService {

    Map<String, Long> riskMitigate(PersonApplicant application);

    /** find person applications in particular page with no of records.
     *
     * @param pageNo
     * @param pageSize
     * @return list of Person Applicants */

    List<PersonApplicant> getAllPersonApplicant(Integer pageNo, Integer pageSize);

    /** @return list of Person Applicants */

    List<PersonApplicant> findApplicants();

    /** find top creditors.
     * 
     * @return list of Person Applicants */

    List<PersonApplicant> findTopPersonCreditors();

    /** find person applications corresponding to particular Id.
     *
     * @param userId
     * @return list of Person Applicants */
    List<PersonApplicant> getHistory(PersonApplicant userId);

}