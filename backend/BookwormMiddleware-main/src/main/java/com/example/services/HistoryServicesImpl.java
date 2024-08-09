package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.History;
import com.example.repositories.IHistoryRepository;

@Service
public class HistoryServicesImpl implements IHistoryServices {

	@Autowired
	private IHistoryRepository historyRepository;
	
	@Override
	public void AddproductinHistory(History history) {
		historyRepository.save(history);
		
		
	}

	@Override
	public List<History> getHistorybyuserId(long id,String type) {
		// TODO Auto-generated method stub
		return  historyRepository.getHistorybyuserId(id,type);
	}

}
