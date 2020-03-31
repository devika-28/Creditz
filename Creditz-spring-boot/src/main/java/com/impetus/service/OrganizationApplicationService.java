package com.impetus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.impetus.model.OrganizationApplicant;


@Service
public interface OrganizationApplicationService {
	
public List<OrganizationApplicant> getAllOrganizationApplicant(Integer pageNo, Integer pageSize);
}
