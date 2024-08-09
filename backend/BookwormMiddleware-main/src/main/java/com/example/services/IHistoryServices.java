package com.example.services;

import java.util.List;

import com.example.entities.History;

public interface IHistoryServices {
   
	public void AddproductinHistory(History history);
	
	public List<History> getHistorybyuserId(long id,String type);
	
}
