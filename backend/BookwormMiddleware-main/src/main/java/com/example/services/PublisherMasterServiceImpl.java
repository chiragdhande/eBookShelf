package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.PublisherMaster;
import com.example.repositories.PublisherMasterRepository;

@Service
public class PublisherMasterServiceImpl implements IPublisherMasterServices {

	@Autowired
	private PublisherMasterRepository masterRepository;
	
	@Override
	public List<PublisherMaster> getallpublisher() {
		// TODO Auto-generated method stub
		return masterRepository.findAll();
	}

	@Override
	public void AddPublisher(PublisherMaster master) {
		masterRepository.save(master);
		
	}

}
