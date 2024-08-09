package com.example.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.Integer;
import com.example.entities.Customer;
import com.example.services.IRentMyshelfServices;
import com.example.services.IUserMyshelf;
import com.example.services.IUserRentShelfServices;
import com.example.services.UserServices;

@RestController
@RequestMapping("/api/Customer")
@CrossOrigin("*") 
public class CustomerController {

	@Autowired
	private UserServices services;
	
	@Autowired
	private IUserMyshelf userMyshelf;
	
	@Autowired
	private IUserRentShelfServices iRentMyshelfServices;
	
	@GetMapping("/{id}")
	public Customer getcustomer(@PathVariable long id)
	{
		return services.getuserbyid(id);
	}
	
	@GetMapping("/count/{id}")
	 public Map<String,Integer> getcountNoBook(@PathVariable long id)
	 {
		Map<String, Integer> map = new HashMap<>();
		int countofbuybook= (int)userMyshelf.getcountofBuybook(id);
		int countofRentbook= iRentMyshelfServices.getcountofRentbook(id);
		map.put("Buybookcount", countofbuybook);
		map.put("RentBookcount", countofRentbook);
		return map;
		 
	 }
}
