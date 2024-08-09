package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MyConfig {
//	 @Bean
//	    public UserDetailsService userDetailsService() {
//	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	        String encodedPassword = passwordEncoder.encode("123");
//	        UserDetails user = User.builder().username("Mayur").password(encodedPassword).roles("ADMIN").build();
//	        return new InMemoryUserDetailsManager(user);
//	    }
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
	      System.out.println("1");
  return builder.getAuthenticationManager();
}

	 
}