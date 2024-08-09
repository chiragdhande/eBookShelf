package com.example.entities;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@CrossOrigin("*")
public class UsersMyshelf {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long UsersMyshelfid;
	
	
	
	@ManyToOne
	private Myshelf myshelf;
	
	@ManyToOne
	private ProductMaster productMaster;

	public long getUsersMyshelfid() {
		return UsersMyshelfid;
	}

	public void setUsersMyshelfid(long usersMyshelfid) {
		UsersMyshelfid = usersMyshelfid;
	}

	
	public Myshelf getMyshelf() {
		return myshelf;
	}

	public void setMyshelf(Myshelf myshelf) {
		this.myshelf = myshelf;
	}

	public ProductMaster getProductMaster() {
		return productMaster;
	}

	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}

	@Override
	public String toString() {
		return "UsersMyshelf [UsersMyshelfid=" + UsersMyshelfid + ", myshelf=" + myshelf + ", productMaster="
				+ productMaster + "]";
	}

		
	
	
	
	
	
}
