package com.example.services;

import java.util.List;

import com.example.entities.PurchesCart;

public interface PurchesProductServices {
	
	public PurchesCart AddCart(PurchesCart purchesCart);
	
	public List<PurchesCart> getcartfromCartId(long id);

	public void deletebyid(long id);

	public void deletebyidandtype(long cartid, String type);
	

}
