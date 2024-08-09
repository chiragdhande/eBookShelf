package com.example.dtos;

public class RoyaltySendtdo {
   
	private String name;
	private double Amount;
	private long Authorid;
	private String productName;
	private long productprice;
	private String CustomerName;
	private long CustomerID;
	private String type;
	
	
	public long getProductprice() {
		return productprice;
	}
	public void setProductprice(long productprice) {
		this.productprice = productprice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public long getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(long customerID) {
		CustomerID = customerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	
	
	public long getAuthorid() {
		return Authorid;
	}
	public void setAuthorid(long authorid) {
		Authorid = authorid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
