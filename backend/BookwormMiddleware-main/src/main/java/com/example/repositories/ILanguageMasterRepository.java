package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.LanguageMaster;

import jakarta.transaction.Transactional;

public interface ILanguageMasterRepository extends JpaRepository<LanguageMaster, Long>{

	@Modifying
	@Transactional
	@Query("SELECT lm FROM LanguageMaster lm WHERE lm.productTypeMaster.typeId = :type_id")
	  public List<LanguageMaster> getlangaugebytypeid(@Param("type_id") long type_id);
	
}
