package com.impetus.security;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpBasicAuthenticationHeader {
	private static final Logger LOG = LoggerFactory.getLogger(HttpBasicAuthenticationHeader.class);
	/**
	 * 
	 * @param auth
	 * @return string value
	 */
	public String decoder(String auth) {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decodedByteArray = decoder.decode((auth.split(" "))[1]);

		LOG.info("HttpBasicAuth");
		return new String(decodedByteArray);
	}
}