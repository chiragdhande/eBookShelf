package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.History;
import com.example.services.IHistoryServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/history")
public class HistoryController {
   
	@Autowired
	private IHistoryServices services;
	
	
	@GetMapping("/{id}/{type}")
	public List<History> getallHistoryofuser(@PathVariable long id,@PathVariable String type)
	{
		  
		return services.getHistorybyuserId(id,type);
		
	}
	
}
