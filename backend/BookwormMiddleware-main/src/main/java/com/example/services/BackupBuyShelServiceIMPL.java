package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.BackupUserBuyedShelf;
import com.example.repositories.BackupBuyShelfRepository;
@Service
public class BackupBuyShelServiceIMPL  implements BackupBuyServices{

	@Autowired
	private BackupBuyShelfRepository backupBuyShelfRepository;
	@Override
	public List<BackupUserBuyedShelf> getallList() {
		// TODO Auto-generated method stub
		return backupBuyShelfRepository.findAll();
	}

}
