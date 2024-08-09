package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.RoyaltyMaster;

import jakarta.transaction.Transactional;

public interface RoyaltyRepository  extends JpaRepository<RoyaltyMaster , Long>{
    @Transactional
   @Query(value = "select * from royalty_master where author_master_authorid=:author_master_authorid ",nativeQuery = true)
	List<RoyaltyMaster> GetRoyaltyByAuthorid( @Param("author_master_authorid") long id);

    @Transactional
    @Query(value = "select * from royalty_master where publisher_master_publisherid=:publisher_master_publisherid ",nativeQuery = true)
	List<RoyaltyMaster> GetRoyaltyByPublisherid( @Param("publisher_master_publisherid") long id);

}
