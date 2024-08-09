package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Myshelf;
import com.example.entities.RentShelf;
import com.example.repositories.RentShelfRepository;

@Service
public class RentShelfServicesImpl implements IRentMyshelfServices {

	@Autowired
	 private RentShelfRepository rentShelfRepository;
	@Override
	public void AddRentShelf(RentShelf shelf) {
		
		rentShelfRepository.save(shelf);
	}

	@Override
	public List<RentShelf> getAllRentShelf() {
		// TODO Auto-generated method stub
		return  rentShelfRepository.findAll();
	}

	@Override
	public long getRentshelfbyCustomerid(long id) {
		// TODO Auto-generated method stub
		return rentShelfRepository.getRentShelfidbyCustomerid( id);
	}

	@Override
	public RentShelf getshelf(long shelfId) {
		// TODO Auto-generated method stub
		return rentShelfRepository.findById(shelfId).orElse(null);
	}

	

}
