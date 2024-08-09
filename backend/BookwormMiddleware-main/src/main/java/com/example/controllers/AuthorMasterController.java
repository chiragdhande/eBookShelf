package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.AuthorMaster;
import com.example.services.AuthorMasterServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/author")
public class AuthorMasterController {
   
	@Autowired
	 private AuthorMasterServices authorMasterServices;
	  
	@GetMapping
	public List<AuthorMaster> getallAuthor()
	{
		return authorMasterServices.getallAuthors();
	}
	
	@PostMapping
	public void AddAuthor(AuthorMaster authorMaster)
	{
		authorMasterServices.AddAuthor(authorMaster);
	}
}
