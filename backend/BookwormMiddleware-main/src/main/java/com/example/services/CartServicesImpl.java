package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Cart;
import com.example.entities.Customer;
import com.example.repositories.CartRepository;
@Service
public class CartServicesImpl implements ICarteServices {
    
	@Autowired
     private CartRepository repository;
	@Override
	public void AddCartproduct(Cart cart) {
		// TODO Auto-generated method stub
		repository.save(cart);
		
	}

	@Override
	public List<Cart> getallcart() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteCartbyid(long id) {
		// TODO Auto-generated method stub
		repository.customdeleteById(id);
		
	}

	@Override
	public void deletecarts(long id) {
		// TODO Auto-generated method stub
		repository.deleteAllRecords();
	}

	@Override
	public void resettoonecartid() {
		// TODO Auto-generated method stub
		repository.resettoonecartid();
		
	}

	@Override
	public Cart getcartbyId(long id) {
		
		return  repository.findById(id).orElse(null);
	}

	@Override
	public long getuseridfromcartid(long id) {
		
		return repository.getuseridfromcartid(id);
	}
	
	public List<Customer> getCustomerbyCartId(long id)
	{
		return repository.getCustomerbyCartId(id);
	}

}
