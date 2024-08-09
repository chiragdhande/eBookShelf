package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Myshelf;
import com.example.repositories.IMyshelfRepository;

@Service
public class MyshelfServicesImpl implements IMyshelfServices{

	@Autowired
	private IMyshelfRepository repository;
	@Override
	public void AddproductinMyshelf(Myshelf myshelf) {
		// TODO Auto-generated method stub
		repository.save(myshelf);
	}

	@Override
	public List<Myshelf> getallproductinMyshelf() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public long getshelfbyid(long id) {
		// TODO Auto-generated method stub
		return  repository.getshelfbyid(id);
	}

	@Override
	public Myshelf getshelf(long myshelfId) {
		// TODO Auto-generated method stub
		return repository.findById(myshelfId).orElse(null);
	}

}
