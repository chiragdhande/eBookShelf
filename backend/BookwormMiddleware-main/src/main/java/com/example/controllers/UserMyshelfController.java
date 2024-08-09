package com.example.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.Cartdtos;
import com.example.dtos.Myshelfdtos;
import com.example.dtos.SendMyshelfdtos;
import com.example.entities.AuthorMaster;
import com.example.entities.Cart;
import com.example.entities.Customer;
import com.example.entities.History;
import com.example.entities.Myshelf;
import com.example.entities.ProductMaster;
import com.example.entities.PublisherMaster;
import com.example.entities.RoyaltyMaster;
import com.example.entities.UsersMyshelf;
import com.example.services.ICarteServices;
import com.example.services.IHistoryServices;
import com.example.services.IMyshelfServices;
import com.example.services.IProductMasterServicees;
import com.example.services.IRoyaltyServices;
import com.example.services.IUserMyshelf;
import com.example.services.PurchesProductServices;
import com.example.services.UserServices;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/Usermyshelf")
@CrossOrigin("*")                       
public class  UserMyshelfController {
   
	@Autowired                                       
	private IMyshelfServices Mservices;
	@Autowired
	private IProductMasterServicees Pservicees;
	
	@Autowired
	private IUserMyshelf userMyshelfservices;
    
	@Autowired
	private ICarteServices carteServices;
	@Autowired
	private PurchesProductServices purchesProductServices;
	
	@Autowired
	private IHistoryServices historyServices;
	
	@Autowired
	private IRoyaltyServices iRoyaltyServices;
	
	@Transactional
	@PostMapping("/add/{cartid}/{myshelfId}/{type}")
	public void AddproductinMyshelf( @RequestBody List<Myshelfdtos> myshelfdtoslist, @PathVariable long cartid ,@PathVariable  long myshelfId ,@PathVariable String type ) {
		// TODO Auto-generated method stub
		   
		
		      purchesProductServices.deletebyidandtype(cartid,type);
		    
		    Myshelf myshelf =  Mservices.getshelf(myshelfId) ;
		        
		    
		    for(Myshelfdtos myshelfdtos : myshelfdtoslist)
		    {
		    	UsersMyshelf usersMyshelf=new UsersMyshelf();
		    	  usersMyshelf.setMyshelf(myshelf);
		    	    
		    	  ProductMaster productMaster = Pservicees.getproductbyId(myshelfdtos.getProductId());
		    	  usersMyshelf.setProductMaster(productMaster);
		    	  
		    	  userMyshelfservices.Addusermyshelf(usersMyshelf);
		    	  
		    }	
		    AddHistory(myshelfdtoslist, cartid);
		    AddRoyalty(myshelfdtoslist,cartid,type);
		   
	}
	@Transactional
	private void AddRoyalty(List<Myshelfdtos> myshelfdtoslist,long cartid,String type)
	{
	  
		Cart cart = carteServices.getcartbyId(cartid);
		   Customer  customer = cart.getCustomer();
		 for(Myshelfdtos myshelfdtos : myshelfdtoslist )
		 { 
			 RoyaltyMaster royaltyMaster = new RoyaltyMaster();
			 ProductMaster productMaster = Pservicees.getproductbyId(myshelfdtos.getProductId());
			 AuthorMaster authorMaster = productMaster.getAuthorMaster();
			 PublisherMaster publisherMaster = productMaster.getPublisherMaster();
			 
			 double AuthorAmount = authorMaster.getAuthorcharges()*productMaster.getProductBasePrice() ;
			  double PublisherAmount= publisherMaster.getPublishercharges()*productMaster.getProductBasePrice();
			 
			 royaltyMaster.setAuthorAmount(AuthorAmount);
			 royaltyMaster.setPublisherAmount(PublisherAmount);
			 royaltyMaster.setType(type);
			 royaltyMaster.setPublisherMaster(publisherMaster);
			 royaltyMaster.setCustomer(customer);
			 royaltyMaster.setAuthorMaster(authorMaster);
			 royaltyMaster.setProductMaster(productMaster);
			 iRoyaltyServices.AddRoyalty(royaltyMaster);
		 }
	}
	@Transactional
	private void AddHistory(List<Myshelfdtos> myshelfdtoslist,long cartid)
	{
		 long userid=carteServices.getuseridfromcartid(cartid);
		 for(Myshelfdtos  myshelfdtos:myshelfdtoslist)
		 {
			  ProductMaster productMaster = Pservicees.getproductbyId(myshelfdtos.getProductId());
			    History history = new History();
			    history.setCustomer(userid);
			    history.setImagePpath(productMaster.getImagePpath());
			    history.setProductISBN(productMaster.getProductISBN());
			    history.setProductName(productMaster.getProductName());
			    history.setProductPrice(productMaster.getProductBasePrice());
			    history.setType("Buy");
			    history.setDate(LocalDate.now());
			    history.setTime(LocalTime.now());
			    historyServices.AddproductinHistory(history);
			    
		 }
	}
	
	
    @GetMapping("{id}")	
	public List<SendMyshelfdtos> getallproductinMyshelf(@PathVariable long id) {
	   
    	 List<UsersMyshelf>  listruserMyshelf=userMyshelfservices.getshelfproductbyid(id);
    	 
    	 List<SendMyshelfdtos> listsendmyshelfdtos = new ArrayList<>();
    	for(UsersMyshelf usersMyshelf :listruserMyshelf )
    	{
    		SendMyshelfdtos sendMyshelfdtos = new SendMyshelfdtos();   
    	     sendMyshelfdtos.setImgpath(usersMyshelf.getProductMaster().getImagePpath());
    	   sendMyshelfdtos.setProductname(usersMyshelf.getProductMaster().getProductName());
    	   sendMyshelfdtos.setPdfUrl(usersMyshelf.getProductMaster().getPdfurl());
    	   listsendmyshelfdtos.add(sendMyshelfdtos);
    	}
    	   return listsendmyshelfdtos;
     	
	}
}
