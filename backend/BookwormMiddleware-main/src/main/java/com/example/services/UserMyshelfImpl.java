package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dtos.SendMyshelfdtos;
import com.example.entities.UsersMyshelf;
import com.example.repositories.UserMyshelfRepository;

@Service
public class UserMyshelfImpl implements IUserMyshelf {

	
	@Autowired
	private UserMyshelfRepository usermyshelfRepository;
	
	@Override
	public void Addusermyshelf(UsersMyshelf usersMyshelf) {
		// TODO Auto-generated method stub
		usermyshelfRepository.save(usersMyshelf);
	}

	@Override
	public List<UsersMyshelf> getshelfproductbyid(long id) {
		// TODO Auto-generated method stub
		return  usermyshelfRepository.getshelfproductbyid(id);
	}

	@Override
	public long getcountofBuybook(long id) {
		
		return usermyshelfRepository.getcount(id);
	}

}
