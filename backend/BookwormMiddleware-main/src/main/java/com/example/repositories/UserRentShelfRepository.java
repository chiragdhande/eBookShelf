package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.RentShelf;
import com.example.entities.UserRentShelf;

import jakarta.transaction.Transactional;

public interface UserRentShelfRepository extends JpaRepository<UserRentShelf, Long> {

	
	@Transactional
	@Query(value = " Select * from user_rent_shelf where rent_shelf_rent_shelf=:rent_shelf_rent_shelf",nativeQuery = true)
	List<UserRentShelf> getproductbyRentshelfid(@Param("rent_shelf_rent_shelf") long id);

	@Transactional
	@Query(value = "select  count(*) from user_rent_shelf where rent_shelf_rent_shelf=:rent_shelf_rent_shelf",nativeQuery = true)
	int getcountofRentbook( @Param("rent_shelf_rent_shelf") long id);



}
