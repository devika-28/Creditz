package com.impetus.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.impetus.model.OrganizationApplicant;
import com.impetus.repository.CibilReportRepository;
import com.impetus.repository.OrganizationApplicationRepository;

@Service
public class OrganizationApplicationServiceImplementation implements OrganizationApplicationService{
	
	@Autowired(required=true) 
	OrganizationApplicationRepository organizationApplication;

	public List<OrganizationApplicant>getAllOrganizationApplicant(Integer pageNo, Integer pageSize){
        System.out.println("inside service impl");

		Pageable paging = PageRequest.of(pageNo, pageSize);
        System.out.println(paging);

        Page<OrganizationApplicant> pagedResult = organizationApplication.findAll(paging);
        System.out.println(pagedResult);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<OrganizationApplicant>();
        }
    }
	}