package com.impetus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @author dell
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.impetus")
public class RMSAuthConfiguration {

}