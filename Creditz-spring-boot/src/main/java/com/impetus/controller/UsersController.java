package com.impetus.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.impetus.model.User;
import com.impetus.service.UsersService;

@RestController
public class UsersController {
	Logger logger = Logger.getLogger("UserController");
    @Autowired UsersService service;
	@CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getAllAnalyst")
    public List<User>getAllAnalyst(
                        @RequestParam(defaultValue="0") int pageNo, 
                        @RequestParam(defaultValue="1") int pageSize)
    {
    	System.out.println(pageNo);
        return service.getAllAnalyst(pageNo, pageSize);
 
       
    }
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/deleteAnalyst")
	void deleteAnalyst(@RequestParam String userEmail)
	{
		logger.info("Delete Request Arrived .");
		service.DeleteAnalyst(userEmail);
	}
}
