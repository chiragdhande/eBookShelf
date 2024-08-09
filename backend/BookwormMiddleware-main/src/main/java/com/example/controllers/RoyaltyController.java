package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.RoyaltySendtdo;
import com.example.entities.RoyaltyMaster;
import com.example.services.IRoyaltyServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Royalty")
public class RoyaltyController  {
   
	@Autowired
	private IRoyaltyServices iRoyaltyServices;
	
	@GetMapping("/author/{id}")
	public List<RoyaltySendtdo> GetRoyaltyByAuthorid(@PathVariable long id)
	{
		List<RoyaltyMaster> list= iRoyaltyServices.GetRoyaltyByAuthorid(id);
		  List<RoyaltySendtdo> sendlist= new ArrayList<>();
		  for(RoyaltyMaster royaltyMaster :list)
		  {
			  RoyaltySendtdo  royaltySendtdo = new RoyaltySendtdo();
			  royaltySendtdo.setName(royaltyMaster.getAuthorMaster().getAuthorname());
			  royaltySendtdo.setAuthorid(royaltyMaster.getAuthorMaster().getAuthorid());
			  royaltySendtdo.setAmount(royaltyMaster.getAuthorAmount());
			  royaltySendtdo.setProductName(royaltyMaster.getProductMaster().getProductName());
			  royaltySendtdo.setCustomerName(royaltyMaster.getCustomer().getCustomerName());
			  royaltySendtdo.setCustomerID(royaltyMaster.getCustomer().getCustomerId());
			  royaltySendtdo.setType(royaltyMaster.getType());
			  royaltySendtdo.setProductprice(royaltyMaster.getProductMaster().getProductBasePrice());
			  sendlist.add(royaltySendtdo);
		  }
		  return sendlist;
		  
	}
	@GetMapping("/publisher/{id}")
	public List<RoyaltySendtdo> GetRoyaltyBypublisherid(@PathVariable long id)
	{
		List<RoyaltyMaster> list= iRoyaltyServices.GetRoyaltyByPublisherid(id);
		  List<RoyaltySendtdo> sendlist= new ArrayList<>();
		  for(RoyaltyMaster royaltyMaster :list)
		  {
			  RoyaltySendtdo  royaltySendtdo = new RoyaltySendtdo();
			  royaltySendtdo.setName(royaltyMaster.getAuthorMaster().getAuthorname());
			  royaltySendtdo.setAuthorid(royaltyMaster.getAuthorMaster().getAuthorid());
			  royaltySendtdo.setAmount(royaltyMaster.getAuthorAmount());
			  royaltySendtdo.setProductName(royaltyMaster.getProductMaster().getProductName());
			  royaltySendtdo.setCustomerName(royaltyMaster.getCustomer().getCustomerName());
			  royaltySendtdo.setCustomerID(royaltyMaster.getCustomer().getCustomerId());
			  royaltySendtdo.setType(royaltyMaster.getType());
			  royaltySendtdo.setProductprice(royaltyMaster.getProductMaster().getProductBasePrice());
			  sendlist.add(royaltySendtdo);
		  }
		  return sendlist;
		  
	}
	
}
