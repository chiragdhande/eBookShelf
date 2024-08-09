package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.History;

import jakarta.transaction.Transactional;

public interface IHistoryRepository extends JpaRepository<History, Long> {
    
	@Transactional
	@Query(value = " Select * from history where customer=:customer and type=:type",nativeQuery = true)
	List<History> getHistorybyuserId(@Param("customer") long id,@Param("type") String type);

}
