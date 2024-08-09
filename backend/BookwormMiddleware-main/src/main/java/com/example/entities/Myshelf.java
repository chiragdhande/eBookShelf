package com.example.entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Myshelf {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long shelfId;   
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "customerId" )
	    private Customer customer;
	   
	    
       
		public Long getShelfId() {
			return shelfId;
		}

		public void setShelfId(Long shelfId) {
			this.shelfId = shelfId;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customerId) {
			this.customer = customerId;
		}

		@Override
		public String toString() {
			return "Myshelf [shelfId=" + shelfId + ", customerId=" + customer + "]";
		}

	

		
	     
	    
	    
	    

}
