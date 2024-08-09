package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AuthorMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Authorid;
	private String Authorname;
	private double Authorcharges;
	private String Pdfurl;
	
	public String getPdfurl() {
		return Pdfurl;
	}
	public void setPdfurl(String pdfurl) {
		Pdfurl = pdfurl;
	}
	public long getAuthorid() {
		return Authorid;
	}
	public void setAuthorid(long authorid) {
		Authorid = authorid;
	}
	public String getAuthorname() {
		return Authorname;
	}
	public void setAuthorname(String authorname) {
		Authorname = authorname;
	}
	public double getAuthorcharges() {
		return Authorcharges;
	}
	public void setAuthorcharges(double authorcharges) {
		Authorcharges = authorcharges;
	}
	@Override
	public String toString() {
		return "AuthorMaster [Authorid=" + Authorid + ", Authorname=" + Authorname + ", Authorcharges=" + Authorcharges
				+ "]";
	}
	
	
}
