package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.entities.ProductMaster;

import com.example.services.IProductMasterServicees;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/productmaster")
public class ProductMasterController {
   
    @Autowired
    private IProductMasterServicees services;

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody ProductMaster productMaster) {
        try {
            services.addBooks(productMaster);
            return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding Book");
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductMaster>> getAllProducts() {
        List<ProductMaster> products = services.getallproducts();
        return ResponseEntity.ok(products);
    }
    
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductMaster> getProductById(@PathVariable long id) {
        ProductMaster product = services.getproductbyId(id);
        return ResponseEntity.ok(product);
    }
    
    @GetMapping("/getproductbylanguage/{id}")
    public ResponseEntity<List<ProductMaster>> getProductByLanguageId(@PathVariable long id) {
        List<ProductMaster> productsByLanguage = services.getproductbylanguageid(id);
        return ResponseEntity.ok(productsByLanguage);
    }
    
 
    
   
    
    
    
}
