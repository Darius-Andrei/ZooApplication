package com.PS.demo.dto;

import com.PS.demo.model.Animal;
import com.PS.demo.model.Zoo;

import lombok.*;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZooMapDTO {
    private Long id;

    private List<Animal> animals;
    private String url;
    private Zoo zoo;
}

