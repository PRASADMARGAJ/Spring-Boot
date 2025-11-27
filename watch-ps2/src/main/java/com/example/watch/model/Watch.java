package com.example.watch.model;



import com.example.watch.model.enums.Catgeries;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class Watch {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Catgeries catgeries;  // now using enum instead of String

    private String smallDescription;

    @Lob
    private String description;

    private Integer sellingPrice;
    private Integer discountedPrice;

    @Lob
    private byte[] watchImage; // store actual image in DB 

    public void setwatchImages(byte[] bytes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setwatchImages'");
    }

    public byte[] getwatchImages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getwatchImages'");
    }
}
