package com.impetus.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/** Basic Authentication Entry point of the applications. */
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	/**
	 * Start the authentication by setting response status and adding header.
	 * 
	 * @param request       HttpServlet Request
	 * @param response      HttpServlet Response
	 * @param authException Authentication Exception
	 */
	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) throws IOException {

		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");

		PrintWriter writer = response.getWriter();
		writer.println("HTTP Status 401 : " + authException.getMessage());
	}

	/** set REALM name to RMS_REALM. */
	@Override
	public void afterPropertiesSet() {
		setRealmName("RMS_REALM");
		super.afterPropertiesSet();
	}
}