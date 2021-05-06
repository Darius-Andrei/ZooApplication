package com.PS.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Animal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String animalClass;
    private String animalOrder;
    private String animalFamily;
    private String animalGenusAndSpecies;
    private String description;

    @Lob
    private byte[] image;

    @ManyToOne
    @JsonIgnore
    private ZooMap zooMap;

    private String url;

    private String wikipediaURL;

}
