package com.greatlearning.studentfest.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.greatlearning.studentfest.studentservice.MyUserDetailsService;



@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	MyUserDetailsService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);

	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console", "/h2-console/**");

	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/list", "/delete","/add","/save","/showFormForUpdate","/403")
		.hasRole("ADMIN")
		.antMatchers("/list","/add","/save")
		.hasAnyRole("ADMIN","USER")
		.anyRequest().authenticated().and()
		.formLogin().and().logout().and().exceptionHandling().accessDeniedPage("/403")		
		.and()
        .cors().and().csrf().disable();
	
		
	}
	
	

}
