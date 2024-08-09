package com.example.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PurchesCart {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long Id;
	
	 private String type;
	
	  @ManyToOne
	  private Cart cart;
	  
	  @ManyToOne
	  private ProductMaster productMaster;
	  
	  

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

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

	@Override
	public String toString() {
		return "PurchesCart [Id=" + Id + ", type=" + type + ", cart=" + cart + ", productMaster=" + productMaster + "]";
	}

	

	
	  
	  
	  
	
	
	
}
