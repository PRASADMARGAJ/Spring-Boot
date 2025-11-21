package com.example.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRUD.Model.Avenger;

public interface RepositoryAvenger extends JpaRepository<Avenger,Long> {
    
}
