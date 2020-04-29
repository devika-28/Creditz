package com.impetus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.model.Organization;
import com.impetus.repository.OrganizationRepository;

@Service
public class OrganizationServiceImplementation implements OrganizationService {

	private static final Logger LOG = LoggerFactory.getLogger(OrganizationServiceImplementation.class);
    @Autowired
    private OrganizationRepository organization;

    /** Find Organization details on the basis of userId.
     *
     * @param userId
     * @return Organization */
    @Override
    public Organization findOrganizationByUserId(Long userId) {
        return organization.findOrganizationByUserId(userId);
    }
}
