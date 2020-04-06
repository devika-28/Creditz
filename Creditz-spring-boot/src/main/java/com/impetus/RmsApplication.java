package com.impetus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.impetus.controller.UserController;
import com.impetus.model.OrganizationApplicant;

@SpringBootApplication
public class RmsApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext a=SpringApplication.run(RmsApplication.class, args);
		System.out.println(System.getProperty("user.dir"));
		
//		UserController o=a.getBean(UserController.class);
//		
//		o.findOrganizationApplicantByUserId(2);
//		
	}
	
	

}
