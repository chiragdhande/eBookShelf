package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.entities.PurchesCart;
import com.example.repositories.IPurchesCartRepository;

@Service
public class PurchesProductServicesImpl implements PurchesProductServices{
	@Autowired
	private IPurchesCartRepository repository;

	@Override
	public PurchesCart AddCart(PurchesCart purchesCart) {
		// TODO Auto-generated method stub
	PurchesCart data=	repository.save(purchesCart);
	return data;
	}

	@Override
	public List<PurchesCart> getcartfromCartId(long id) {
		// TODO Auto-generated method stub
		return repository.findcartfromcartid(id);
	}

	@Override
	public void deletebyid(long id) {
	     repository.deleteByCartId(id);
	
	}


	@Override
	public void deletebyidandtype(long cartid, String type) {
		// TODO Auto-generated method stub
		  repository.deleteByCartIdandtype(cartid, type);
	}

	 

}
