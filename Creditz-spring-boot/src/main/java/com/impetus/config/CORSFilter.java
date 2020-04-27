package com.impetus.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/** CORS filter, for HTTP Header, configurations. */
public class CORSFilter implements Filter {

    /** Filter servlet requests and set header.
     * 
     * @param req
     *            Servlet Request
     * @param res
     *            Servlet response
     * @param chain
     *            Filter chain */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
        chain.doFilter(req, res);
    }

    /** @param filterConfig
     *            filter Configuration */
    @Override
    public void init(FilterConfig filterConfig) {
        // Do Nothing
    }

    @Override
    public void destroy() {
        // Do Nothing
    }

}