package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.RentShelf;

import jakarta.transaction.Transactional;

public interface RentShelfRepository extends JpaRepository<RentShelf, Long> {

	
	@Transactional
	@Query(value = "select rent_shelf from rent_shelf  where customer_id=:customer_id" ,nativeQuery = true)
	long getRentShelfidbyCustomerid(@Param("customer_id") long id);

	
	

}
