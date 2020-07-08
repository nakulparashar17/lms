//package com.jkt.training.auth;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//@Configuration
//public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter{
//
//	protected void configure(HttpSecurity http) throws Exception {
//		  http
//	        .csrf().disable()   
//	        .authorizeRequests()
//	        .antMatchers(HttpMethod.OPTIONS,"/**")
//	        .permitAll()
//	        .antMatchers(HttpMethod.POST,"/login").permitAll()
//	                .anyRequest().authenticated()
//	                .and()
//	            //.formLogin().and()
//	            .httpBasic().disable();
//	    }
//}