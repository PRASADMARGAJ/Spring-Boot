package com.example.CRUD.Model;

import org.springframework.stereotype.Controller;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Controller
@Data
public class Avenger {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String heroic_name; 
}
