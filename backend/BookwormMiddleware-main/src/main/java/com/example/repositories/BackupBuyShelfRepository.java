package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.BackupUserBuyedShelf;

public interface BackupBuyShelfRepository extends JpaRepository<BackupUserBuyedShelf, Long> {

}
