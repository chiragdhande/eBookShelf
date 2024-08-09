package com.example.dtos;

import java.time.LocalDate;

public class SendRentshlef {
	private String imgpath;
	private String  productname;
	private  String pdfUrl;
	private long days;
	private LocalDate startdate;
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPdfUrl() {
		return pdfUrl;
	}
	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}
	public long getDays() {
		return days;
	}
	public void setDays(long days) {
		this.days = days;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	@Override
	public String toString() {
		return "SendRentshlef [imgpath=" + imgpath + ", productname=" + productname + ", pdfUrl=" + pdfUrl + ", days="
				+ days + ", startdate=" + startdate + "]";
	}
	
	
}
