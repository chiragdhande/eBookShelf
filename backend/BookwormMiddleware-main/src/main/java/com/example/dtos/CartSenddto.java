package com.example.dtos;

public class CartSenddto {

   private long cartid;	
   private String imagePpath; 
   private String ProductName;  
   private long ProductPrice;
	private long productid;
    private String type;
     
    

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	
	public long getCartid() {
		return cartid;
	}
	public void setCartid(long cartid) {
		this.cartid = cartid;
	}
	
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	@Override
	public String toString() {
		return "CartSenddto [cartid=" + cartid + ", imagePpath=" + imagePpath + ", ProductName=" + ProductName
				+ ", ProductPrice=" + ProductPrice + ", productid=" + productid + "]";
	}
	
	
	
	
	
}
