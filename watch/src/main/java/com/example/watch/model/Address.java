package com.example.watch.model;

import com.example.watch.model.enums.State;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Address {
 @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String area;
    private String city;
    
    
    @Enumerated(EnumType.STRING)
    private State state;

    private Integer pincode;

    @ManyToOne   //Many addresses can belong to one user.
    @JoinColumn(name = "user_id")   //user_id column will be created in address table as a foreign key to User.id
    private User user;  //Is a reference to the User object in Java.
}  
    

