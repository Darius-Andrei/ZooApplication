package com.PS.demo.dto;

import com.PS.demo.model.Zoo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SouvenirDTO {

    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Zoo zoo;
}
