//package com.rapipay.api.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.csrf().disable()
//		       .authorizeRequests()
//		       .anyRequest()
//		       .authenticated()
//		       .and()
//		       .httpBasic();
//		       
//}
//	
//	public void configureGlobal (AuthenticationManagerBuilder authentication)throws Exception
//	
//	{
//		authentication.inMemoryAuthentication()
//		                  .withUser("ira")
//		                  .password(encode().encode( "root"))
//		                  .roles("User");
//		                  
//	}
//	
//	@Bean
//	public PasswordEncoder encode() {
//		return new BCryptPasswordEncoder();
//	}
//
//}
//
