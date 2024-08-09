package com.example.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class BackupUserBuyedShelf {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long  BackupUsersBuyshelfid;
	
	
	private LocalDate buydate;
	@ManyToOne
	private Myshelf myshelf;
	
	@ManyToOne
	private ProductMaster productMaster;

	
	
	public LocalDate getBuydate() {
		return buydate;
	}

	public void setBuydate(LocalDate buydate) {
		this.buydate = buydate;
	}

	public long getBackupUsersBuyshelfid() {
		return BackupUsersBuyshelfid;
	}

	public void setBackupUsersBuyshelfid(long backupUsersBuyshelfid) {
		BackupUsersBuyshelfid = backupUsersBuyshelfid;
	}

	public Myshelf getMyshelf() {
		return myshelf;
	}

	public void setMyshelf(Myshelf myshelf) {
		this.myshelf = myshelf;
	}

	public ProductMaster getProductMaster() {
		return productMaster;
	}

	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}

	@Override
	public String toString() {
		return "BackupUserBuyedShelf [BackupUsersBuyshelfid=" + BackupUsersBuyshelfid + ", buydate=" + buydate
				+ ", myshelf=" + myshelf + ", productMaster=" + productMaster + "]";
	}

	
}
