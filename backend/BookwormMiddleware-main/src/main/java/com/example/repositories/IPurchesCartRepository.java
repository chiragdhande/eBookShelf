package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.PurchesCart;

import jakarta.transaction.Transactional;

public interface IPurchesCartRepository extends JpaRepository<PurchesCart, Long> {

	
	@Modifying
	@Transactional
	@Query("select pm from PurchesCart pm where pm.cart.cartId=:cart_cart_id ")
	List<PurchesCart> findcartfromcartid( @Param("cart_cart_id")  long id);

	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM purches_cart WHERE cart_cart_id= :id and type=:type", nativeQuery = true)
	void deleteByCartIdandtype(@Param("id") long id , @Param("type") String type);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM purches_cart WHERE id=:id", nativeQuery = true)
	void deleteByCartId(@Param("id") long id);


	


}
