package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.ProductMaster;
import com.example.repositories.IProductMasterRepository;

@Service
public class ProductMasterservicesImpl implements IProductMasterServicees {

	
	@Autowired
	private IProductMasterRepository repository;

	@Override
	public void addBooks(ProductMaster products) {
		// TODO Auto-generated method stub
		repository.save(products);
		
	}

	@Override
	public List<ProductMaster> getallproducts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public ProductMaster getproductbyId(long productId) {
		// TODO Auto-generated method stub
		return repository.findById(productId).orElse(null);
	}

	@Override
	public List<ProductMaster> getproductbylanguageid(long language_id) {
		// TODO Auto-generated method stub
		return repository.getproductbylanguageid(language_id);
	}

	@Override
	public int updatequantiydecrement(long quantity,long productid) {
	     int b=repository.updatequantiydecrement(quantity,productid);
	     if(b==1)
	     {
	    	 return b;
	     }
	     else
		return 0;
	}

	@Override
	public long getequantity  (long id) {
		// TODO Auto-generated method stub
		 long b=repository.getquantity(id);
	     return b;
		
	}
   
}
