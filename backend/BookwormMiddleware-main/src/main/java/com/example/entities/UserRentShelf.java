package com.example.entities;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserRentShelf {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long userRentShelfid;
   private long days;
   private LocalDate ExpDate;
   private LocalDate startDate;
   private long rentamount;
   
   @ManyToOne
   private RentShelf rentShelf;
   
   @ManyToOne
   private ProductMaster productMaster;

   
   
public long getDays() {
	return days;
}

public void setDays(long days) {
	this.days = days;
}





public LocalDate getStartDate() {
	return startDate;
}

public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}

public LocalDate getExpDate() {
	return ExpDate;
}

public void setExpDate(LocalDate expDate) {
	ExpDate = expDate;
}

public long getRentamount() {
	return rentamount;
}

public void setRentamount(long rentamount) {
	this.rentamount = rentamount;
}

public long getUserRentShelfid() {
	return userRentShelfid;
}

public void setUserRentShelfid(long userRentShelfid) {
	this.userRentShelfid = userRentShelfid;
}

public RentShelf getRentShelf() {
	return rentShelf;
}

public void setRentShelf(RentShelf rentShelf) {
	this.rentShelf = rentShelf;
}

public ProductMaster getProductMaster() {
	return productMaster;
}

public void setProductMaster(ProductMaster productMaster) {
	this.productMaster = productMaster;
}

@Override
public String toString() {
	return "UserRentShelf [userRentShelfid=" + userRentShelfid + ", days=" + days + ", ExpDate=" + ExpDate
			+ ", startDate=" + startDate + ", rentamount=" + rentamount + ", rentShelf=" + rentShelf
			+ ", productMaster=" + productMaster + "]";
}





   
   
}
