package com.impetus.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.impetus.model.PersonApplicant;
import com.impetus.model.User;


@Service
public interface PersonApplicationService {
	
	public HashMap<String,Long> RiskMitigate(PersonApplicant application);
	
	
	public List<PersonApplicant> getAllPersonApplicant(Integer pageNo, Integer pageSize);
	
                     public List<PersonApplicant>findApplicants();
    

	public List<PersonApplicant> findTopPersonCreditors();


	List<PersonApplicant> getHistory(PersonApplicant userId);


}