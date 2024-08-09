package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RoyaltyMaster {
     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
	private long royaltyID;
     
     @ManyToOne
     private AuthorMaster authorMaster;
     
     @ManyToOne
     private PublisherMaster publisherMaster;
     
     @ManyToOne
     private Customer customer;
     
     @ManyToOne
     private ProductMaster productMaster;
     
     private double PublisherAmount;
     
     private double AuthorAmount;

	 private String type;
	 
	 
	 

	public ProductMaster getProductMaster() {
		return productMaster;
	}


	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public long getRoyaltyID() {
		return royaltyID;
	}


	public void setRoyaltyID(long royaltyID) {
		this.royaltyID = royaltyID;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public AuthorMaster getAuthorMaster() {
		return authorMaster;
	}

	public void setAuthorMaster(AuthorMaster authorMaster) {
		this.authorMaster = authorMaster;
	}

	public PublisherMaster getPublisherMaster() {
		return publisherMaster;
	}

	public void setPublisherMaster(PublisherMaster publisherMaster) {
		this.publisherMaster = publisherMaster;
	}

	public double getPublisherAmount() {
		return PublisherAmount;
	}

	public void setPublisherAmount(double publisherAmount) {
		PublisherAmount = publisherAmount;
	}

	public double getAuthorAmount() {
		return AuthorAmount;
	}

	public void setAuthorAmount(double authorAmount) {
		AuthorAmount = authorAmount;
	}


	@Override
	public String toString() {
		return "RoyaltyMaster [royaltyID=" + royaltyID + ", authorMaster=" + authorMaster + ", publisherMaster="
				+ publisherMaster + ", customer=" + customer + ", productMaster=" + productMaster + ", PublisherAmount="
				+ PublisherAmount + ", AuthorAmount=" + AuthorAmount + ", type=" + type + "]";
	}


	


	

	
     
	
}
