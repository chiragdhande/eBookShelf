package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Myshelf;

import jakarta.transaction.Transactional;

public interface IMyshelfRepository  extends JpaRepository<Myshelf, Long>{

	
	@Transactional
	@Query(value = "select shelf_id from myshelf  where customer_id=:customer_id" ,nativeQuery = true)
	long getshelfbyid( @Param ("customer_id") long id);

}
