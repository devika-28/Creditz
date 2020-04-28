package com.impetus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.PersonApplicant;
import com.impetus.service.PersonApplicationService;

@RestController
public class PersonApplicationController {

    @Autowired
    private PersonApplicationService service;

    /** Function to calculate risk on the basis of persons application.
     * 
     * @param application
     *            Person application
     * @return set the risk status into database */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/individual-user/user-application")
    public Map<String, Long> personApplicantApplicationSubmit(@RequestBody PersonApplicant application) {

        return service.riskMitigate(application);

    }

    /** find person applications corresponding to particular Id.
     *
     * @param userId
     * @return list of Person Applicants */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/individual-user/user-history")
    public List<PersonApplicant> personHistory(@RequestBody PersonApplicant userId) {

        return service.getHistory(userId);

    }

    /** find all person applicants.
     *
     * @return list of person Applicants */

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getPersonApplicants")
    public List<PersonApplicant> getAllPersonApplicant(){
        return service.getAllPersonApplicant();

    }

    /** find top creditors.
     * 
     * @return list of Person Applicants */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getTopPersonApplicants")
    public List<PersonApplicant> findTopPersonCreditors() {
        return service.findTopPersonCreditors();

    }

}
