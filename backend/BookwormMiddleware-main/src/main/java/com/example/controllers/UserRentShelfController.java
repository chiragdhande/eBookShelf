package com.example.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.Myshelfdtos;
import com.example.dtos.ReciveRentShlefdto;
import com.example.dtos.SendRentshlef;
import com.example.entities.AuthorMaster;
import com.example.entities.Cart;
import com.example.entities.Customer;
import com.example.entities.History;
import com.example.entities.ProductMaster;
import com.example.entities.PublisherMaster;
import com.example.entities.RentShelf;
import com.example.entities.RoyaltyMaster;
import com.example.entities.UserRentShelf;
import com.example.services.ICarteServices;
import com.example.services.IHistoryServices;
import com.example.services.IProductMasterServicees;
import com.example.services.IRentMyshelfServices;
import com.example.services.IRoyaltyServices;
import com.example.services.IUserRentShelfServices;
import com.example.services.PurchesProductServices;

@RestController
@RequestMapping("/api/UserRentShelf")
@CrossOrigin("*")  
public class UserRentShelfController {
  
	@Autowired
	private ICarteServices carteServices;
	@Autowired
	private IProductMasterServicees Pservicees;
	
	@Autowired
	private IRentMyshelfServices iRentMyshelfServices;
	
	@Autowired
	private PurchesProductServices purchesProductServices;
	
    @Autowired
    private IUserRentShelfServices iUserRentShelfServices;
    
    @Autowired
	private IHistoryServices historyServices;
    
    @Autowired
	private IRoyaltyServices iRoyaltyServices;
    
    @PostMapping("/addRentShelf/{cartid}/{myshelfId}/{type}")
    public void AddProductInRentShelf(@RequestBody List<ReciveRentShlefdto> rentShlefdto ,@PathVariable long cartid ,@PathVariable  long myshelfId ,@PathVariable String type  )
    {    
    	 purchesProductServices.deletebyidandtype(cartid, type);
    	RentShelf rentshelf = iRentMyshelfServices.getshelf(myshelfId);
    	  for(ReciveRentShlefdto reciveRentShlefdto:rentShlefdto)
    	  {
    		  UserRentShelf userRentShelf= new UserRentShelf();
    		   userRentShelf.setProductMaster( Pservicees.getproductbyId(reciveRentShlefdto.getProductId()));
    		    
    		   userRentShelf.setDays(  reciveRentShlefdto.getDays());
    		   
    		   userRentShelf.setExpDate( reciveRentShlefdto.getExpDate());
    		   userRentShelf.setStartDate(reciveRentShlefdto.getStartDate());
    		     System.out.println(reciveRentShlefdto.getExpDate()+"***********");
    		  userRentShelf.setRentamount( reciveRentShlefdto.getRentamount());
    		  userRentShelf.setRentShelf(rentshelf);
    		  iUserRentShelfServices.AdduserRentmyshelf(userRentShelf);
    		  
    		 AddHistory(reciveRentShlefdto.getRentamount(),reciveRentShlefdto.getProductId(),cartid);
    	  }
    	  
    	  AddRoyalty(rentShlefdto,cartid);
    }
	
    
    private void AddRoyalty(List<ReciveRentShlefdto> rentShlefdto, long cartid) {
		Cart cart = carteServices.getcartbyId(cartid);
		Customer customer = cart.getCustomer();
		  for(ReciveRentShlefdto reciveRentShlefdto :rentShlefdto )
		  {
			  RoyaltyMaster royaltyMaster = new RoyaltyMaster();
				 ProductMaster productMaster = Pservicees.getproductbyId(reciveRentShlefdto.getProductId());
				 AuthorMaster authorMaster = productMaster.getAuthorMaster();
				 PublisherMaster publisherMaster = productMaster.getPublisherMaster();
				 
				 double AuthorAmount = authorMaster.getAuthorcharges()*reciveRentShlefdto.getRentamount();
				  double PublisherAmount= publisherMaster.getPublishercharges()*reciveRentShlefdto.getRentamount();
				 
				 royaltyMaster.setAuthorAmount(AuthorAmount);
				 royaltyMaster.setPublisherAmount(PublisherAmount);
				 royaltyMaster.setType("Rent");
				 royaltyMaster.setPublisherMaster(publisherMaster);
				 royaltyMaster.setCustomer(customer);
				 royaltyMaster.setAuthorMaster(authorMaster);
				 royaltyMaster.setProductMaster(productMaster);
				 iRoyaltyServices.AddRoyalty(royaltyMaster);  
		  }
		
	}


	private void AddHistory(long amount,long productid ,long cartid)
	{
		 long userid=carteServices.getuseridfromcartid(cartid);
		
			  ProductMaster productMaster = Pservicees.getproductbyId(productid);
			    History history = new History();
			    history.setCustomer(userid);
			    history.setImagePpath(productMaster.getImagePpath());
			    history.setProductISBN(productMaster.getProductISBN());
			    history.setProductName(productMaster.getProductName());
			    history.setProductPrice(amount);
			    history.setType("Rent");
			    history.setDate(LocalDate.now());
			    history.setTime(LocalTime.now());
			    historyServices.AddproductinHistory(history);
			    
		 
	}
    
    @GetMapping("{id}") 
    public List<SendRentshlef> GetallRentBook(@PathVariable long id)
    {
    	List<UserRentShelf> list= iUserRentShelfServices.getproductbyRentshelfid(id);
    	  
    	  List<SendRentshlef> sendRentshlefslist= new ArrayList<>();
    	   LocalDate currentdate = LocalDate.now();
    	   
    	   for(UserRentShelf rentShelf: list)
    	   {
    		  
    		   
    		   if(currentdate.isAfter(rentShelf.getExpDate()))
    		   {
    			   iUserRentShelfServices.DeletExpBook(rentShelf.getUserRentShelfid());
    		   }
    		   else if(currentdate.isEqual(rentShelf.getStartDate()) || rentShelf.getStartDate().isBefore(currentdate))
    		   {
    			
    			  SendRentshlef Srentshlef  = new SendRentshlef();
    			  int days=     (int)ChronoUnit.DAYS.between(rentShelf.getExpDate(), currentdate);
    			  Srentshlef.setDays(days);
    			   System.out.println(days);
    			  Srentshlef.setImgpath(rentShelf.getProductMaster().getImagePpath());
    			    
    			                 
    			  Srentshlef.setPdfUrl(rentShelf.getProductMaster().getPdfurl());
    			  Srentshlef.setProductname(rentShelf.getProductMaster().getProductName());
    			  Srentshlef.setStartdate(rentShelf.getStartDate());
    			  sendRentshlefslist.add(Srentshlef);
    		   }
    		   
    	   }
    	   
		return sendRentshlefslist;
    	
    }
	
	
}
