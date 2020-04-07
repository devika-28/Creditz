package com.impetus.service;

<<<<<<< HEAD

=======
import java.util.HashMap;
>>>>>>> 80813169cc27329ac8862c640cc0c27c55978bfa
import java.util.List;

import org.springframework.stereotype.Service;

import com.impetus.model.OrganizationApplicant;

@Service
public interface OrganizationApplicationService {
	
<<<<<<< HEAD
public List<OrganizationApplicant> getAllOrganizationApplicant(Integer pageNo, Integer pageSize);

public List<OrganizationApplicant> findApplicants();

public List<OrganizationApplicant> findTopPersonCreditors();
=======
	public HashMap<String,Long> organizationRiskMitigate(OrganizationApplicant application);
	
     public List<OrganizationApplicant> getAllOrganizationApplicant(Integer pageNo, Integer pageSize);
         //  public OrganizationApplicant  findByUserId(long userId);

>>>>>>> 80813169cc27329ac8862c640cc0c27c55978bfa

}
