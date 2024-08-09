package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.AuthorMaster;
import com.example.repositories.AuthorRepository;

@Service
public class AuthorMasterServicesIMpl implements AuthorMasterServices {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<AuthorMaster> getallAuthors() {
		
		return authorRepository.findAll();
	}

	@Override
	public void AddAuthor(AuthorMaster authorMaster) {
	   authorRepository.save(authorMaster);
		
	}

}
