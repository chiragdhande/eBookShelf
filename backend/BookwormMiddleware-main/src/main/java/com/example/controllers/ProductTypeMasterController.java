package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.ProductTypeMaster;
import com.example.services.IProductTypeMasterServices;

@RestController
@CrossOrigin("*")

@RequestMapping("/api/producttype")
public class ProductTypeMasterController {
   @Autowired
   private IProductTypeMasterServices services;
   
   @PostMapping
   public void addtype(@RequestBody ProductTypeMaster type)
   {
	   services.Addtype(type);
   }
   @GetMapping
   public List<ProductTypeMaster> getalltype()
   {
	   System.out.println("in type controller");
	   List<ProductTypeMaster> types = services.getalltype(); 
	   
	   return types;
   }
   
}
