package com.PS.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Donation extends PurchasableItem {
    public Donation(Long id, String name, Double price, String description){
        super(id,name,price);
        this.description=description;
    }
    private String description;

}
