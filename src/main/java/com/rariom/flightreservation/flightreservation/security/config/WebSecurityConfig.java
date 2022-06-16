package com.rariom.flightreservation.flightreservation.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http){
        try {
            http.authorizeRequests().antMatchers(
                    "/registerPage",
                    "/index.html",
                    "/registered",
                    "//loginPage",
                    "/login/*"
                    ).permitAll()// all can access the endpoints
                    .antMatchers("/admin/showAddFlight")// can only be access by admin role
                    .hasIpAddress("ADMIN")
                    .anyRequest().authenticated().and().csrf().disable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
