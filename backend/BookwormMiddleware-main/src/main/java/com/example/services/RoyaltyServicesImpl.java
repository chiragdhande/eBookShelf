package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.RoyaltyMaster;
import com.example.repositories.RoyaltyRepository;
@Service
public class RoyaltyServicesImpl implements IRoyaltyServices {

	 
	@Autowired
	private RoyaltyRepository repository;
	@Override
	public void AddRoyalty(RoyaltyMaster master) {
		// TODO Auto-generated method stub
		repository.save(master);
	}

	@Override
	public List<RoyaltyMaster> getAllRoyalty() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<RoyaltyMaster> GetRoyaltyByAuthorid(long id) {
		// TODO Auto-generated method stub
		return repository.GetRoyaltyByAuthorid(id);
	}

	@Override
	public List<RoyaltyMaster> GetRoyaltyByPublisherid(long id) {
		// TODO Auto-generated method stub
		return  repository.GetRoyaltyByPublisherid(id);
	}

}
