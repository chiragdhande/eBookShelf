package com.example.services;

import java.util.List;

import com.example.entities.Myshelf;

public interface IMyshelfServices {
  public void AddproductinMyshelf(Myshelf myshelf) ;
  public List<Myshelf> getallproductinMyshelf();
  public long getshelfbyid(long id);
public Myshelf getshelf(long myshelfId); 
  
  
}
