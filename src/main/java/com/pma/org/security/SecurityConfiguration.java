package com.pma.org.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	javax.sql.DataSource dataSource;
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, password, enabled "+
				"from user_accounts where username= ?")
		.authoritiesByUsernameQuery("select username, role "+
		"from user_accounts where username= ?")
		.dataSource(dataSource)
		.passwordEncoder(bCryptEncoder); 
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		  // antMatchers("/employees/new").hasAuthority("ADMIN").
		//antMatchers("/employees/save").hasAuthority("ADMIN").//hasRole need to update DB update projectmanagementapp.user_accounts set role='ROLE_ADMIN'  where username='Shabad';
		//antMatchers("/projects/new").hasAuthority("ADMIN").
		//antMatchers("/projects/save").hasAuthority("ADMIN").
		antMatchers("/","/**").permitAll().and().formLogin();
		//http.csrf().disable();
	}
	
    
	
}
