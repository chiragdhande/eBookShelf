package com.example.services;

import java.util.List;

import com.example.entities.PublisherMaster;

public interface IPublisherMasterServices {

	public List<PublisherMaster> getallpublisher();
	public void AddPublisher(PublisherMaster master);
	
}
