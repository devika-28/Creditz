package com.impetus.service;

import org.springframework.stereotype.Service;

import com.impetus.model.Organization;

@Service
public interface OrganizationService {
	/**
	 * Find Organization details on the basis of userId.
	 *
	 * @param userId
	 * @return Organization
	 */
	Organization findOrganizationByUserId(Long userId);
}
