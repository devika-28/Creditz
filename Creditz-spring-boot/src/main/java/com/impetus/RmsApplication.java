package com.impetus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RmsApplication {

	public static void main(String[] args) {
	SpringApplication.run(RmsApplication.class, args);
		System.out.println(System.getProperty("user.dir"));
		
//		UserController o=a.getBean(UserController.class);
//		
//		o.findOrganizationApplicantByUserId(2);
//		
	}
}
