package com.example.controllers;

import java.util.List;

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

import com.example.entities.LanguageMaster;
import com.example.services.ILanguageMasterServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/languageMaster")
public class LanguageMasterController {

    @Autowired
    private ILanguageMasterServices services;

    @PostMapping
    public ResponseEntity<String> addLanguage(@RequestBody LanguageMaster language) {
        try {
            services.AddLanguage(language);
            return ResponseEntity.status(HttpStatus.CREATED).body("Language added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding language");
        }
    }

    @GetMapping
    public ResponseEntity<List<LanguageMaster>> getAllLanguages() {
        List<LanguageMaster> languages = services.getallLanguages();
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageMaster> getLanguageById(@PathVariable long id) {
        LanguageMaster language = services.getLanguageByID(id);
        if (language != null) {
            return ResponseEntity.ok(language);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getlanguagebytypeid/{id}")
    public List<LanguageMaster> getLanguageByTypeId(@PathVariable long id) {
        return services.getlangaugebytypeid(id);
    }
}
