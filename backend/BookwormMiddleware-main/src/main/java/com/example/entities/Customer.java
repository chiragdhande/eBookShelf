package com.example.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer implements  UserDetails{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    
    private String customerName;
    private String Email;
    private String customerEmail;
    private String password;
    private String primium;
    private String gender;
    private String Address;
    private String City;
    private long Pincode;
    private long ContactNo;
    private String Role;
    
    
    
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPrimium() {
		return primium;
	}
	public void setPrimium(String primium) {
		this.primium = primium;
	}
	public long getContactNo() {
		return ContactNo;
	}
	public void setContactNo(long contactNo) {
		ContactNo = contactNo;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.customerEmail;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public long getPincode() {
		return Pincode;
	}
	public void setPincode(long pincode) {
		Pincode = pincode;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", Email=" + Email
				+ ", customerEmail=" + customerEmail + ", password=" + password + ", primium=" + primium + ", gender="
				+ gender + ", Address=" + Address + ", City=" + City + ", Pincode=" + Pincode + ", ContactNo="
				+ ContactNo + ", Role=" + Role + "]";
	}
	
	
    
    
}
