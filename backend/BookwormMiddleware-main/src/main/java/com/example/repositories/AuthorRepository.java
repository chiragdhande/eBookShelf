package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.AuthorMaster;

public interface AuthorRepository  extends JpaRepository<AuthorMaster, Long>{

}
