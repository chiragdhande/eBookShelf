package com.example.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.entities.Cart;
import com.example.entities.Customer;

public interface ICarteServices {
   public void AddCartproduct(Cart cart);
   public List<Cart> getallcart();
   public void deleteCartbyid(long id);
   public void deletecarts(long id);
   public void resettoonecartid();
   public Cart getcartbyId(long id);
   long getuseridfromcartid( long id) ;
   List<Customer> getCustomerbyCartId(long id);
}
