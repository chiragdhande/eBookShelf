	package com.example.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class LanguageMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;

    private String languageDesc;
    
    private String images;

    @ManyToOne
    @JoinColumn(name = "typeId")  
    private ProductTypeMaster productTypeMaster;

    

    // Constructors, getters, and setters
        
     

	public Long getLanguageId() {
		return languageId;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getLanguageDesc() {
		return languageDesc;
	}

	public void setLanguageDesc(String languageDesc) {
		this.languageDesc = languageDesc;
	}

	

	public ProductTypeMaster getProductTypeMaster() {
		return productTypeMaster;
	}

	public void setProductTypeMaster(ProductTypeMaster productTypeMaster) {
		this.productTypeMaster = productTypeMaster;
	}

	@Override
	public String toString() {
		return "LanguageMaster [languageId=" + languageId + ", languageDesc=" + languageDesc + ", images=" + images
				+ ", productTypeMaster=" + productTypeMaster + "]";
	}

	
}
