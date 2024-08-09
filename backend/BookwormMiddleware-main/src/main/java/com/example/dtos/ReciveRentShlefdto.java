package com.example.dtos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ReciveRentShlefdto {
	
	 private long productId;
	   private long days;
	   private LocalDate expDate;
	   private LocalDate startDate;
	   private long rentamount;
	public long getProductId() {
		return productId;
	}
	
	
	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getDays() {
		return days;
	}
	public void setDays(long days) {
		this.days = days;
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate ExpDate) {
		this.expDate = ExpDate;
	}
	public long getRentamount() {
		return rentamount;
	}
	public void setRentamount(long rentamount) {
		this.rentamount = rentamount;
	}


	@Override
	public String toString() {
		return "ReciveRentShlefdto [productId=" + productId + ", days=" + days + ", expDate=" + expDate + ", startDate="
				+ startDate + ", rentamount=" + rentamount + "]";
	}
	
	
}
