package com.example.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class RentShelf {
 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long RentShelf;   
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "customerId" )
	    private Customer customer;

		public Long getRentShelf() {
			return RentShelf;
		}

		public void setRentShelf(Long rentShelf) {
			RentShelf = rentShelf;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "RentShelf [RentShelf=" + RentShelf + ", customer=" + customer + "]";
		}
	    
	   
}
