package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PublisherMaster {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long publisherid;
	private String PublisherName;
	private   double publishercharges;
    private String Pdfurl;
	
	public String getPdfurl() {
		return Pdfurl;
	}
	public void setPdfurl(String pdfurl) {
		Pdfurl = pdfurl;
	}
	public double getPublishercharges() {
		return publishercharges;
	}
	public void setPublishercharges(double publishercharges) {
		this.publishercharges = publishercharges;
	}
	public long getPublisherid() {
		return publisherid;
	}
	public void setPublisherid(long publisherid) {
		this.publisherid = publisherid;
	}
	public String getPublisherName() {
		return PublisherName;
	}
	public void setPublisherName(String publisherName) {
		PublisherName = publisherName;
	}
	@Override
	public String toString() {
		return "PublisherMaster [publisherid=" + publisherid + ", PublisherName=" + PublisherName
				+ ", publishercharges=" + publishercharges + "]";
	}
	
          
}
