package com.example.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.passworddto;
import com.example.entities.Cart;
import com.example.entities.Customer;
import com.example.entities.JwtRequest;
import com.example.entities.JwtResponse;
import com.example.entities.Myshelf;
import com.example.entities.RentShelf;
import com.example.repositories.CartRepository;
import com.example.security.JwtHelper;
import com.example.services.ICarteServices;
import com.example.services.IMyshelfServices;
import com.example.services.IRentMyshelfServices;
import com.example.services.UserServices;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private UserServices userServices;
    
    @Autowired
    private ICarteServices services;
    
    @Autowired
    private IMyshelfServices myshelfServices;
    
    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private IRentMyshelfServices RentMyshelfServices;
    

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
    	  System.out.println("  0");
        this.doAuthenticate(request.getEmail(), request.getPassword());
                  

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
              
        String token = this.helper.generateToken(userDetails);
        long userid=userServices.getuserIdByusername(userDetails.getUsername());
        long cardid=  cartRepository.getCartidFromuserid(userid);
        long Myshelfid = myshelfServices.getshelfbyid(userid);
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername())
                 .userId(userid)
                 .cardId(cardid)
                 .MyshelfId(Myshelfid)
                 .build();
                
           
               
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
    	System.out.println(email + " " + password);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
           System.out.println(authentication);
        try {
        	  //System.out.println(1);
            manager.authenticate(authentication);
            //System.out.println(1);

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }
    @PostMapping("/create-user")
    public Customer createUser(@RequestBody Customer customer)
    {
    	Customer customer2= userServices.createUser(customer) ; 
    	  
    	
    	Assigncart(customer);
    	AssignMyshelf(customer);
    	AssignRentShelf(customer);
    	return customer2;
    }
       
    private void Assigncart(Customer customer)
    {
    	Cart cart = new  Cart();
    	cart.setCustomer(customer); 
    	
    	services.AddCartproduct(cart);
    	
    }
      
    private void AssignMyshelf(Customer customer)
    {
    	Myshelf myshelf=new Myshelf();
    	myshelf.setCustomer(customer);
    	myshelfServices.AddproductinMyshelf(myshelf);
    	
    }
    
    private void AssignRentShelf(Customer customer)
    {
    	RentShelf rentShelf = new RentShelf();
    	  rentShelf.setCustomer(customer);
    	  RentMyshelfServices.AddRentShelf(rentShelf);
    }
     
   
     @GetMapping("/getuser")
    public List<Customer> getCustomers()
    {
    	return userServices.getusers();
    }
     @GetMapping("/getuserbyid/{Id}")
     public Customer getcustomerbyid(@PathVariable long Id)
     {
    	 return userServices.getuserbyid(Id);
     }
    
     @PostMapping("/update")
     public ResponseEntity<String> updatePassword(@RequestBody passworddto password)
     {
         boolean isUpdated = userServices.updatepassword(password.getUsername(), password.getPassword());

         if (isUpdated) {
             return ResponseEntity.ok("Password updated successfully");
         } else {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update password");
         }
     } 
     }

   


