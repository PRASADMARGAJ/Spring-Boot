package com.example.watch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity

public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne   //Each cart item belongs to one user, but a user can have many cart items.
    @JoinColumn(name = "user_id")   //Creates a column user_id in the cart table that stores the foreign key to User.id
    private User user;    //A Java reference to the User entity.

    @ManyToOne   //Each cart item references one pet, but a pet can appear in many carts.
    @JoinColumn(name = "watch_id")  //Creates a column pet_id in the cart table that stores the foreign key to Pet.id
    private Watch product;  //Java reference to the Pet entity.

    private Integer quantity = 1;
}

