package com.PS.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PurchasableItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private Double price;

    public PurchasableItem(Long id,String name,Double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    private Boolean toExpose;

    @ManyToOne
    @JsonIgnore
    private MyUser myUser;
}
