package com.example.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    // ...
    private String productName;
	private String productEnglishName;
     private String imagePpath  ;                  
	  private String productAuthor  ;
	
     private long productBasePrice    ;        
	private String productDescription ;         
	private long  productISBN;                               
	private Date productExpiryDate ;
    
	private String Pdfurl;
	
	@ManyToOne
	private AuthorMaster authorMaster;
	 
	@ManyToOne
	private PublisherMaster publisherMaster;
	
	
	
	
	
    @ManyToOne
    @JoinColumn(name = "typeId")
    private ProductTypeMaster productTypeMaster;

    @ManyToOne
    @JoinColumn(name = "languageId")
    private LanguageMaster languageMaster;

    // Constructors, getters, and setters
        
    

    
    
	public Long getProductId() {
		return productId;
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

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductEnglishName() {
		return productEnglishName;
	}

	public void setProductEnglishName(String productEnglishName) {
		this.productEnglishName = productEnglishName;
	}

	public String getImagePpath() {
		return imagePpath;
	}

	public void setImagePpath(String imagePpath) {
		this.imagePpath = imagePpath;
	}

	public String getProductAuthor() {
		return productAuthor;
	}

	public void setProductAuthor(String productAuthor) {
		this.productAuthor = productAuthor;
	}

	public long getProductBasePrice() {
		return productBasePrice;
	}

	public void setProductBasePrice(long productBasePrice) {
		this.productBasePrice = productBasePrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public long getProductISBN() {
		return productISBN;
	}

	public void setProductISBN(long productISBN) {
		this.productISBN = productISBN;
	}

	public Date getProductExpiryDate() {
		return productExpiryDate;
	}

	public void setProductExpiryDate(Date productExpiryDate) {
		this.productExpiryDate = productExpiryDate;
	}

	public ProductTypeMaster getProductTypeMaster() {
		return productTypeMaster;
	}

	public void setProductTypeMaster(ProductTypeMaster productTypeMaster) {
		this.productTypeMaster = productTypeMaster;
	}

	public LanguageMaster getLanguageMaster() {
		return languageMaster;
	}

	public void setLanguageMaster(LanguageMaster languageMaster) {
		this.languageMaster = languageMaster;
	}
  

    
	public String getPdfurl() {
		return Pdfurl;
	}

	public void setPdfurl(String pdfurl) {
		Pdfurl = pdfurl;
	}

	@Override
	public String toString() {
		return "ProductMaster [productId=" + productId + ", productName=" + productName + ", productEnglishName="
				+ productEnglishName + ", imagePpath=" + imagePpath + ", productAuthor=" + productAuthor
				+ ", productBasePrice=" + productBasePrice + ", productDescription=" + productDescription
				+ ", productISBN=" + productISBN + ", productExpiryDate=" + productExpiryDate + ", Pdfurl=" + Pdfurl
				+ ", authorMaster=" + authorMaster + ", publisherMaster=" + publisherMaster + ", productTypeMaster="
				+ productTypeMaster + ", languageMaster=" + languageMaster + "]";
	}

	

	
	
	
	
}
