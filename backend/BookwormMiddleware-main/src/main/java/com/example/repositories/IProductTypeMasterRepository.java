package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.ProductTypeMaster;

public interface IProductTypeMasterRepository extends JpaRepository<ProductTypeMaster, Long> {

}
