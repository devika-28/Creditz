package com.impetus.config;
//package com.impetus.rms.config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//@Configuration
//
//public class SecurityConfig {
//    protected void configure(HttpSecurity http) throws Exception 
//    {
//        http
//         .csrf().disable()
//         .authorizeRequests().anyRequest().authenticated()
//         .and()
//         .httpBasic();
//    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) 
//            throws Exception 
//    {
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER", "ADMIN");
//    }
//
//}
