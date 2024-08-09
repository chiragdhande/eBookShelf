package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.SendBackupByedBook;
import com.example.dtos.SendBackupRentedBook;
import com.example.entities.BackupUserBuyedShelf;
import com.example.entities.BackupUserRentShelf;
import com.example.services.BackupBuyServices;
import com.example.services.BackupRentServices;

@RestController   
@CrossOrigin("*")
@RequestMapping("/api/backup")
public class BackupController {
  
	@Autowired
	private BackupBuyServices backupBuyServices;
	
	@Autowired
	private BackupRentServices backupRentServices;
	
	
	@GetMapping("/buy")
	public List<SendBackupByedBook> getallBackupBuyedBook() {
		List<BackupUserBuyedShelf> list = backupBuyServices.getallList();
		List<SendBackupByedBook> buylist = new ArrayList<>();
		for(BackupUserBuyedShelf backupUserBuyedShelf :list)
		{
			SendBackupByedBook byedBook = new SendBackupByedBook();
			byedBook.setAuthorname(backupUserBuyedShelf.getProductMaster().getAuthorMaster().getAuthorname());
			byedBook.setDate(backupUserBuyedShelf.getBuydate());
			byedBook.setProductname(backupUserBuyedShelf.getProductMaster().getProductName());
			byedBook.setProductprice(backupUserBuyedShelf.getProductMaster().getProductBasePrice());
			byedBook.setPublishername(backupUserBuyedShelf.getProductMaster().getPublisherMaster().getPublisherName());
			byedBook.setUserid(backupUserBuyedShelf.getMyshelf().getCustomer().getCustomerId());
			byedBook.setUsername(backupUserBuyedShelf.getMyshelf().getCustomer().getUsername());
			buylist.add(byedBook);
		}
		return buylist;
	}
	
	@GetMapping("/rent")
   public List<SendBackupRentedBook> getallBackupRentededBook() {
		List<BackupUserRentShelf> list=backupRentServices.getallList();
		  
		List<SendBackupRentedBook> Rentlist = new ArrayList<>();
		for(BackupUserRentShelf rentShelf :list)
		{
			SendBackupRentedBook backupRentedBook= new SendBackupRentedBook();
			backupRentedBook.setAuthorname(rentShelf.getProductMaster().getAuthorMaster().getAuthorname());
			backupRentedBook.setEaxpdate(rentShelf.getExpDate());
			backupRentedBook.setIssuedate(rentShelf.getStartDate());
			backupRentedBook.setNoofdays(rentShelf.getDays());
			backupRentedBook.setProductname(rentShelf.getProductMaster().getProductName());
			backupRentedBook.setProductprice(rentShelf.getRentamount());
			backupRentedBook.setPublishername(rentShelf.getProductMaster().getPublisherMaster().getPublisherName());
			backupRentedBook.setUserid(rentShelf.getRentShelf().getCustomer().getCustomerId());
			backupRentedBook.setUsername(rentShelf.getRentShelf().getCustomer().getUsername());
			Rentlist.add(backupRentedBook);
			
		}
		
		return Rentlist;
	}
}
