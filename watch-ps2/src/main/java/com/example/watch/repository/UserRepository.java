package com.example.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.watch.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
