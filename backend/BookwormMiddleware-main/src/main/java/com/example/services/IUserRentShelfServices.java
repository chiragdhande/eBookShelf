package com.example.services;

import java.util.List;

import com.example.entities.UserRentShelf;
import com.example.entities.UsersMyshelf;

public interface IUserRentShelfServices {
	 public void AdduserRentmyshelf(UserRentShelf shelf);

		public List<UserRentShelf> getproductbyRentshelfid(long id);
		
		public void DeletExpBook(long id);

		public int getcountofRentbook(long id);
}
