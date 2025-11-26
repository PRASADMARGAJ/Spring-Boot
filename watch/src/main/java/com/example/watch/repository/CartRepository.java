package com.example.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.watch.model.Cart;

public interface CartRepository extends JpaRepository< Cart , Long> {
    
}
