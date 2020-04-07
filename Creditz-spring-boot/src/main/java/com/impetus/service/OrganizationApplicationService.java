package com.impetus.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.impetus.model.OrganizationApplicant;


@Service
public interface OrganizationApplicationService {
	
	public HashMap<String,Long> organizationRiskMitigate(OrganizationApplicant application);
	
     public List<OrganizationApplicant> getAllOrganizationApplicant(Integer pageNo, Integer pageSize);
         //  public OrganizationApplicant  findByUserId(long userId);


}
