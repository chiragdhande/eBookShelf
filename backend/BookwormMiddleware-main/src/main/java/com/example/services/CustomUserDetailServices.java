package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entities.Customer;
import com.example.repositories.UserRepository;

@Service
public class CustomUserDetailServices implements UserDetailsService {

	 @Autowired
	 private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 // load user from database
		Customer customer=  userRepository.findBycustomerEmail(username).orElseThrow(()->new RuntimeException("user not found"));
		                     
		return customer;
	}

}
