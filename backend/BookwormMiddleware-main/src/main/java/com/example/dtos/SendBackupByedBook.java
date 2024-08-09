package com.example.dtos;

import java.time.LocalDate;

public class SendBackupByedBook {
   
	private String Productname;
	private long productprice;
	private LocalDate date;
	private String authorname ;
	private String Publishername;
	private String username;
	private long userid;
	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	public long getProductprice() {
		return productprice;
	}
	public void setProductprice(long productprice) {
		this.productprice = productprice;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getPublishername() {
		return Publishername;
	}
	public void setPublishername(String publishername) {
		Publishername = publishername;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
    
}
