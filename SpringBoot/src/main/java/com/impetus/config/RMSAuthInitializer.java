package com.impetus.config;

import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RMSAuthInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	private static final Logger LOG = LoggerFactory.getLogger(RMSAuthInitializer.class);
	/**
	 * configure class
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RMSAuthConfiguration.class };
	}
    
	/**
	 * configure class
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[0];
	}

	/**
	 *configure class 
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * configure class
	 */
	@Override
	protected Filter[] getServletFilters() {
		Filter[] singleton = { new CORSFilter() };
		LOG.info("RMSAuthInitializer::getServletFilters::get servlet filters");
		return singleton;
	}

}