package com.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Customer;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository  extends JpaRepository<Customer, Long>{
    public Optional<Customer> findBycustomerEmail(String email);
    
   
    @Transactional
    @Query(value = "SELECT customer_id FROM customer WHERE customer_email = :customer_email", nativeQuery = true)
    public long getuserIdByusername(@Param("customer_email") String customer_email);

    @Modifying
    @Transactional
    @Query(value = "update customer set password = :password where customer_email = :customer_email", nativeQuery = true) 
     int  updatePassword(@Param("password") String encodedPassword, @Param("customer_email") String customerEmail);


      @Transactional
      @Query(value = "select role from customer where  customer_email=:customer_email",nativeQuery = true)
	 String getUserRole( @Param("customer_email") String username);


}
