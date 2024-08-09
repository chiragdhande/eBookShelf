package com.example.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.entities.LanguageMaster;

public interface ILanguageMasterServices {
   public void AddLanguage(LanguageMaster languages);
   public List<LanguageMaster> getallLanguages();
   public  LanguageMaster getLanguageByID(long languageid);
   public List<LanguageMaster> getlangaugebytypeid( long typeid);
   
}
