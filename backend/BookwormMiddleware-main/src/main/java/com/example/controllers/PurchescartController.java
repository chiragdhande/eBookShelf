package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.CartSenddto;
import com.example.dtos.Cartdtos;
import com.example.entities.Cart;
import com.example.entities.ProductMaster;
import com.example.entities.PurchesCart;
import com.example.services.ICarteServices;
import com.example.services.IProductMasterServicees;
import com.example.services.PurchesProductServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/purchescontroller")
public class PurchescartController {
	
	@Autowired
	private PurchesProductServices purchesProductServices;
	
	@Autowired
	 private ICarteServices carteServices;
	@Autowired
	private IProductMasterServicees productMasterServicees;
	
	@PostMapping
	public ResponseEntity<String> AddCart(@RequestBody Cartdtos cartdtos)
	{
		    
		     
		    		
		    		 PurchesCart purchesCart =new PurchesCart();
		   	      Cart cart =carteServices.getcartbyId(cartdtos.getcartId());
		   	      ProductMaster productMaster=productMasterServicees.getproductbyId(cartdtos.getProductId());
		   	      
		   	      purchesCart.setCart(cart);
		   	      purchesCart.setProductMaster(productMaster);
		   	       purchesCart.setType(cartdtos.getType());
		   	   purchesProductServices.AddCart(purchesCart);
		   	   
		      return null;
	     
	        
	      
	      
	}       
	
	@GetMapping("/getcartbycartid/{cartid}")
	public  List<CartSenddto>  getcartproductbycutomerId(@PathVariable long cartid)
	{ 
		  List<PurchesCart> purchesCarts= purchesProductServices.getcartfromCartId(cartid);
		  List<CartSenddto>list=new ArrayList<>();
		    for(PurchesCart cart: purchesCarts)
		    {
		    	CartSenddto cartSenddto = new CartSenddto();
		    	cartSenddto.setCartid(cart.getId());
		    	 cartSenddto.setImagePpath(cart.getProductMaster().getImagePpath());
		    	 cartSenddto.setProductName(cart.getProductMaster().getProductName());
		    	 cartSenddto.setProductPrice(cart.getProductMaster().getProductBasePrice());
		    	  cartSenddto.setProductid(cart.getProductMaster().getProductId()) ;
		    	   cartSenddto.setType(cart.getType());
		    	 list.add(cartSenddto);
		    }
		   return list;	
	}
	@DeleteMapping("/delete/{id}")
	public void deletebyid(@PathVariable long id)
	{  
		System.out.println("patil");
		  purchesProductServices.deletebyid(id);
		  
	}

}

