package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.RentShelf;
import com.example.entities.UserRentShelf;
import com.example.repositories.UserRentShelfRepository;

@Service
public class UserRentShelfServicesImpl  implements IUserRentShelfServices{

	@Autowired 
	private UserRentShelfRepository rentShelfRepository;
	
	@Override
	public void AdduserRentmyshelf(UserRentShelf shelf) {
		 rentShelfRepository.save(shelf);
		
	}

	@Override
	public List<UserRentShelf> getproductbyRentshelfid(long id) {
		
		return rentShelfRepository.getproductbyRentshelfid(id);
	}

	@Override
	public void DeletExpBook(long id) {
		rentShelfRepository.deleteById(id);
		
	}

	@Override
	public int getcountofRentbook(long id) {
		
		return rentShelfRepository.getcountofRentbook(id);
	}

	
}
