package com.impetus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.Organization;
import com.impetus.service.OrganizationService;

@RestController
public class OrganizationController {

	private static final Logger LOG = LoggerFactory.getLogger(OrganizationController.class);
	@Autowired
	private OrganizationService organizationService;

	/**
	 * Find Organization details on the basis of userId.
	 *
	 * @param userId
	 * @return Organization
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/findOrganizationByUserId")
	public Organization findOrganizationByUserId(@RequestParam Long userId) {
		try {
			LOG.info(
					"OrganizationController::findOrganizationByUserId:: return to findOrganizationByUserId method with userId{}",
					userId);
			return organizationService.findOrganizationByUserId(userId);
		} catch (Exception e) {
			LOG.warn("OrganizationController ::findOrganizationByUserId:: exception occur{0}", e);

		}

		return null;
	}

}
