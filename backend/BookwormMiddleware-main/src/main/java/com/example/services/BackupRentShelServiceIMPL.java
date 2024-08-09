package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.BackupUserRentShelf;
import com.example.repositories.BackupRentshelfReopsitory;

@Service
public class BackupRentShelServiceIMPL  implements BackupRentServices{

	@Autowired
	private BackupRentshelfReopsitory backupRentshelfReopsitory;
	
	@Override
	public List<BackupUserRentShelf> getallList() {
		// TODO Auto-generated method stub
		return backupRentshelfReopsitory.findAll();
	}

}
