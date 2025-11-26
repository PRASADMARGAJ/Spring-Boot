package com.example.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.watch.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
