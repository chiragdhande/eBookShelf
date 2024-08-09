package com.example.dtos;

public class Cartdtos {
  
	private long productId;
	private long cartId; 
	 
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getcartId() {
		return cartId;
	}
	public void setcartId(long cartId) {
		this.cartId = cartId;
	}
	@Override
	public String toString() {
		return "Cartdtos [productId=" + productId + ", cartId=" + cartId + ", type=" + type + "]";
	}
	
	
	
}
