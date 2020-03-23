package com.impetus.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.impetus.model.PersonApplicant;

@Service
public interface PersonApplicationService {
	
	public HashMap<String,Long> RiskMitigate(PersonApplicant application);

}
