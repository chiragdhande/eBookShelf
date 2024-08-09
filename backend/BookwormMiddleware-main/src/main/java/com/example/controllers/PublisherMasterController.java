package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.PublisherMaster;
import com.example.services.IPublisherMasterServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Publisher")
public class PublisherMasterController {
   @Autowired
   private IPublisherMasterServices iPublisherMasterServices;
   
   @GetMapping
   public List<PublisherMaster> getallPublisher()
   {
	   return iPublisherMasterServices.getallpublisher();
   }
   @PostMapping
   public void AddPublisher(PublisherMaster publisherMaster)
   {
	   iPublisherMasterServices.AddPublisher(publisherMaster);
   }
}
