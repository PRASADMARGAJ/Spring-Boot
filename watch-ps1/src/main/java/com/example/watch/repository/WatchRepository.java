package com.example.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.watch.model.Watch;

public interface WatchRepository extends JpaRepository<Watch, Long> {
    
}
