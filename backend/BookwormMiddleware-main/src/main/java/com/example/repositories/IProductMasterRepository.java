package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.ProductMaster;

import jakarta.transaction.Transactional;

public interface IProductMasterRepository extends JpaRepository<ProductMaster, Long> {

	  @Modifying
	  @Transactional
	  @Query("SELECT pm FROM ProductMaster pm WHERE pm.languageMaster.languageId=:language_id")
        public List<ProductMaster> getproductbylanguageid(@Param("language_id") long language_id);

	  
	  
	  @Modifying
	  @Transactional
	  @Query(value = "update product_master set quantity = quantity-:pquantity  where product_id=:product_id",nativeQuery = true)
	    int updatequantiydecrement( @Param("pquantity") long quantity  , @Param("product_id")long productid);


	 
	  @Transactional
	  @Query(value = "select quantity from product_master where product_id=:product_id",nativeQuery = true)
	     long getquantity( @Param("product_id") long id);
}
