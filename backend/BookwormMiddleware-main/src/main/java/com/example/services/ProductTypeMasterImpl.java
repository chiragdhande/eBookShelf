package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.ProductTypeMaster;
import com.example.repositories.IProductTypeMasterRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductTypeMasterImpl implements IProductTypeMasterServices {
   
        @Autowired
        private IProductTypeMasterRepository repository;
	@Override
	public void Addtype(ProductTypeMaster type) {
		
		repository.save(type);
	}

	@Override
	public List<ProductTypeMaster> getalltype() {
		System.out.println("in services");
		return repository.findAll();
	}

}
