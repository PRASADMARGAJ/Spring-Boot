package com.example.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.watch.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
