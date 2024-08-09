package com.example.services;

import java.util.List;

import com.example.dtos.SendMyshelfdtos;
import com.example.entities.UsersMyshelf;

public interface IUserMyshelf {

	 public void Addusermyshelf(UsersMyshelf usersMyshelf);

	public List<UsersMyshelf> getshelfproductbyid(long id);

	public long getcountofBuybook(long id);
	 
}
