package com.impetus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@SpringBootApplication
public class RmsApplication {

	public static void main(String[] args) {
	SpringApplication.run(RmsApplication.class, args);
}
}