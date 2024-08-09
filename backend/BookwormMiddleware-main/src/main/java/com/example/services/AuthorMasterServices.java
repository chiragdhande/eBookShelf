package com.example.services;

import java.util.List;

import com.example.entities.AuthorMaster;

public interface AuthorMasterServices {
  public List<AuthorMaster> getallAuthors();
   public void AddAuthor(AuthorMaster authorMaster);
}
