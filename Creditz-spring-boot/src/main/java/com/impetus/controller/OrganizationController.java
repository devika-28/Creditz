package com.impetus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.Organization;
import com.impetus.service.OrganizationService;

@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    /** Find Organization details on the basis of userId.
     *
     * @param userId
     * @return Organization */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/findOrganizationByUserId")
    public Organization findOrganizationByUserId(@RequestParam Long userId) {
        return organizationService.findOrganizationByUserId(userId);
    }

}
