package com.example.dtos;

import java.time.LocalDate;

public class SendBackupRentedBook {
	private String Productname;
	private long productprice;
	private LocalDate issuedate;
	private LocalDate Eaxpdate;
	private long noofdays;
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
	public LocalDate getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(LocalDate issuedate) {
		this.issuedate = issuedate;
	}
	public LocalDate getEaxpdate() {
		return Eaxpdate;
	}
	public void setEaxpdate(LocalDate eaxpdate) {
		Eaxpdate = eaxpdate;
	}
	public long getNoofdays() {
		return noofdays;
	}
	public void setNoofdays(long noofdays) {
		this.noofdays = noofdays;
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
	@Override
	public String toString() {
		return "SendBackupRentedBook [Productname=" + Productname + ", productprice=" + productprice + ", issuedate="
				+ issuedate + ", Eaxpdate=" + Eaxpdate + ", noofdays=" + noofdays + ", authorname=" + authorname
				+ ", Publishername=" + Publishername + ", username=" + username + ", userid=" + userid + "]";
	}
	
	
}
