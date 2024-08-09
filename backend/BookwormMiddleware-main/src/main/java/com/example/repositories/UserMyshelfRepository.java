package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.dtos.SendMyshelfdtos;
import com.example.entities.UsersMyshelf;

import jakarta.transaction.Transactional;

public interface UserMyshelfRepository extends JpaRepository<UsersMyshelf, Long> {

	
	@Transactional
	@Query(value = "select *  from users_myshelf where myshelf_shelf_id =:myshelf_shelf_id",nativeQuery = true)
	List<UsersMyshelf> getshelfproductbyid( @Param("myshelf_shelf_id") long id);

	@Transactional
	@Query(value = "select  count(*) from users_myshelf where myshelf_shelf_id=:myshelf_shelf_id",nativeQuery = true)
	long getcount( @Param("myshelf_shelf_id") long id);
    
}
