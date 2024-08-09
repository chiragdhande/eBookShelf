package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Cart;
import com.example.entities.Customer;

import jakarta.transaction.Transactional;

public interface CartRepository  extends JpaRepository<Cart, Long>{
  
	   @Modifying
	    @Transactional
	    @Query("DELETE FROM Cart") 
	   public void deleteAllRecords();
	   
	   @Modifying
	    @Transactional
	    @Query("DELETE FROM Cart WHERE cartId = :cart_id")
	   void customdeleteById(@Param("cart_id") long cart_id);
   
	   @Modifying
	   @Transactional
	   @Query(value = "ALTER TABLE Cart AUTO_INCREMENT = 1",nativeQuery = true)
	public void resettoonecartid();
	   
	   
	   @Transactional
	   @Query( value =  "select cart_id from cart where customer_id=:customer_id",nativeQuery = true)
	  long getCartidFromuserid(@Param("customer_id") long  customer_id);
       
	   @Transactional
	   @Query(value = "select customer_id from cart where cart_id=:cart_id", nativeQuery = true)
	    long getuseridfromcartid(@Param("cart_id") long id) ;

	   
	   @Transactional
	   @Query(value = "select cu.*  from customer cu join cart ca on ca.customer_id = cu.customer_id  where ca.cart_id=:cart_id", nativeQuery = true)
	   public List<Customer> getCustomerbyCartId(@Param ("cart_id") long id);
	   
}
//ALTER TABLE Cart AUTO_INCREMENT = 1;

