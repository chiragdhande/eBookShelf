package com.example.services;

import java.util.List;

import com.example.entities.Myshelf;
import com.example.entities.RentShelf;

public interface IRentMyshelfServices {
	public void AddRentShelf(RentShelf shelf) ;
	  public List<RentShelf> getAllRentShelf();
	  public long getRentshelfbyCustomerid(long id);
	public RentShelf getshelf(long myshelfId);
	
}
