package com.example.dtos;

public class SendMyshelfdtos {
    
	private String imgpath;
	private String  productname;
	private  String pdfUrl;
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
	@Override
	public String toString() {
		return "SendMyshelfdtos [imgpath=" + imgpath + ", productname=" + productname + ", pdfUrl=" + pdfUrl + "]";
	}
	
	
}
