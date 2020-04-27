package com.impetus.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
    
	private static String realm = "RMS_REALM";

    /** User details service it fetch user email from database, validate the input password with the salted password, stored in database and return.
     * the the JDBCDaoImpl
     * @param dataSource Data source, JDBC
     * @return JDBC DAO implementation */
    @Bean(name = "userDetailsService")
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
        jdbcImpl.setDataSource(dataSource);
        jdbcImpl.setUsersByUsernameQuery("select user_email,password, 1 from user where user_email=?");
        jdbcImpl.setAuthoritiesByUsernameQuery("select user_email,role from user where user_email=?");
        return jdbcImpl;
    }

    /** using password encoder it decode the password from the database.
     * 
     * @param auth
     *            Authentication Manager Builder */
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordencoder());
    }

    /** using the authentication, it authenticate the url with respect to roles.
     * 
     * @param http
     *            HTTP Security */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().and().httpBasic().realmName(realm)
                .authenticationEntryPoint(getBasicAuthEntryPoint());
    }

    /** Custom authentication entry point.
     * 
     * @return new authentication entry point */
    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
        return new CustomBasicAuthenticationEntryPoint();
    }

    /** Configure web security. */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    /** password encoder.
     * 
     * @return bCruptPasswordEncoder */
    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }

}
