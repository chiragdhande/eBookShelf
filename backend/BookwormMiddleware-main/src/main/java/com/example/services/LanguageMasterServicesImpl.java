package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.LanguageMaster;
import com.example.repositories.ILanguageMasterRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LanguageMasterServicesImpl implements ILanguageMasterServices{

	
	@Autowired
	private ILanguageMasterRepository repository;
	@Override
	public void AddLanguage(LanguageMaster languages) {
		repository.save(languages);
		
	}

	@Override
	public List<LanguageMaster> getallLanguages() {
		
		return repository.findAll();
	}

	@Override
	public LanguageMaster getLanguageByID(long languageid) {
		// TODO Auto-generated method stub
		return repository.getReferenceById(languageid);
	}

	@Override
	public List<LanguageMaster> getlangaugebytypeid(long typeid) {
		// TODO Auto-generated method stub
		return  repository.getlangaugebytypeid(typeid);
	}

}
