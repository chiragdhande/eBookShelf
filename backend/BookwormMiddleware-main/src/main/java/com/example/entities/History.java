package com.example.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
@CrossOrigin("*")
public class History {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long HId; 
	    private String imagePpath; 
	     private String ProductName;  
	     private long ProductPrice;
	     private long productISBN;
		private LocalDate date;
	    private LocalTime time;
	    private long customer;
	    private String type;
	    
		
		
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		
		public long getHId() {
			return HId;
		}
		public void setHId(long hId) {
			HId = hId;
		}
		public long getCustomer() {
			return customer;
		}
		public void setCustomer(long customer) {
			this.customer = customer;
		}
		
		
		public String getImagePpath() {
			return imagePpath;
		}
		public void setImagePpath(String imagePpath) {
			this.imagePpath = imagePpath;
		}
		public String getProductName() {
			return ProductName;
		}
		public void setProductName(String productName) {
			ProductName = productName;
		}
		public long getProductPrice() {
			return ProductPrice;
		}
		public void setProductPrice(long productPrice) {
			ProductPrice = productPrice;
		}
		
		
		
		public LocalTime getTime() {
			return time;
		}
		public void setTime(LocalTime time) {
			this.time = time;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public long getProductISBN() {
			return productISBN;
		}
		public void setProductISBN(long productISBN) {
			this.productISBN = productISBN;
		}
		@Override
		public String toString() {
			return "History [HId=" + HId + ", imagePpath=" + imagePpath + ", ProductName=" + ProductName
					+ ", ProductPrice=" + ProductPrice + ", productISBN=" + productISBN + ", date=" + date + ", time="
					+ time + ", customer=" + customer + ", type=" + type + "]";
		}
		
		
		
	
		
		
		
		
	

}
