package com.example.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entities.Customer;
import com.example.repositories.UserRepository;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder encoder;
     public List<Customer> getusers()
     {
    	 return userRepository.findAll();
     }
     public Customer createUser(Customer customer)
     {
    	 // customer.setCustomerId(UUID.randomUUID().toString());
    	 customer.setPassword(encoder.encode(customer.getPassword()));
    	 return userRepository.save(customer);
     }
     public Customer getuserbyid(long id)
     {
    	 // customer.setCustomerId(UUID.randomUUID().toString());
    	
    	 return userRepository.findById(id).orElse(null);
     }
     public long getuserIdByusername(String username)
     {
    	return userRepository.getuserIdByusername(username);
     }
	public boolean updatepassword(String username, String password) {
	 
		
	        String encodedPassword = encoder.encode(password);
	          
	        int b= userRepository.updatePassword(encodedPassword, username);
	        System.out.println(b);
	        if(b==1)
	        {
	        	 return true;	
	        }
	        else
	        {
	        	return false;
	        }
		
	}
	 
	public String getRoleByUsername(String Username)
	{
		  String role =  userRepository.getUserRole(Username);
		  System.out.println(role+"userservices");
		  return role;
		  
	}
	
	
}
