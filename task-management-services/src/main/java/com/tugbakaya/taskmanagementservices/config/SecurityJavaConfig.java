package com.tugbakaya.taskmanagementservices.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user").password("{noop}user").roles("USER")
		.and()
		.withUser("taskManager").password("{noop}taskManager").roles("TASKMANAGER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/task-management/user/**").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/task-management/criteria/user/**").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/task-management/user/**").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/task-management/criteria/user/**").hasRole("USER")


		.antMatchers(HttpMethod.GET, "/task-management/assignTask/").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/task-management/criteria/assignTask/").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/task-management/endTask").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/task-management/criteria/endTask").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/task-management/listUserTasks").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/task-management/criteria/listUserTasks").hasRole("USER")


		.antMatchers(HttpMethod.GET, "/task-management/task/**").hasRole("TASKMANAGER")
		.antMatchers(HttpMethod.GET, "/task-management/criteria/task/**").hasRole("TASKMANAGER")
		.antMatchers(HttpMethod.POST, "/task-management/task/**").hasRole("TASKMANAGER")
		.antMatchers(HttpMethod.POST, "/task-management/criteria/task/**").hasRole("TASKMANAGER")

        .and()
        .csrf().disable()
        .formLogin().disable();
	}

	

}
