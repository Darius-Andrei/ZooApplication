package com.PS.demo.dto.animal;

import com.PS.demo.model.ZooMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Lob;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnimalDTO {
    private Long id;
    private String name;
    private String animalClass;
    private String animalOrder;
    private String animalFamily;
    private String animalGenusAndSpecies;
    private String description;
    @Lob
    private byte[] image;
    private String url;
    private String wikipediaURL;
}
