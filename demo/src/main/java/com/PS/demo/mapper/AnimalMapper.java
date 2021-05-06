package com.PS.demo.mapper;

import com.PS.demo.dto.animal.AnimalDTO;
import com.PS.demo.dto.animal.AnimalLittleDetailsDTO;
import com.PS.demo.model.Animal;

import java.util.LinkedList;
import java.util.List;

public class AnimalMapper {
    public static AnimalDTO mapperAnimalToDTO(Animal animal){
        AnimalDTO animalDTO=new AnimalDTO();
        animalDTO.setId(animal.getId());
        animalDTO.setAnimalClass(animal.getAnimalClass());
        animalDTO.setAnimalFamily(animal.getAnimalFamily());
        animalDTO.setAnimalOrder(animal.getAnimalOrder());
        animalDTO.setAnimalGenusAndSpecies(animal.getAnimalGenusAndSpecies());
        animalDTO.setDescription(animal.getDescription());
        animalDTO.setName(animal.getName());
        animalDTO.setImage(animal.getImage());
        animalDTO.setUrl(animal.getUrl());
        animalDTO.setWikipediaURL(animal.getWikipediaURL());
        return animalDTO;
    }

    public static Animal mapperDTOToAnimal(AnimalDTO animalDTO){
        Animal animal=new Animal();
        animal.setId(animalDTO.getId());
        animal.setAnimalClass(animalDTO.getAnimalClass());
        animal.setAnimalFamily(animalDTO.getAnimalFamily());
        animal.setAnimalOrder(animalDTO.getAnimalOrder());
        animal.setAnimalGenusAndSpecies(animalDTO.getAnimalGenusAndSpecies());
        animal.setDescription(animalDTO.getDescription());
        animal.setName(animalDTO.getName());
        animal.setImage(animalDTO.getImage());
        animal.setUrl(animalDTO.getUrl());
        animal.setWikipediaURL(animalDTO.getWikipediaURL());
        return animal;
    }

    public static List<AnimalLittleDetailsDTO> mapperDTOLittleDetailsToAnimal(List<Animal> animals){
        List<AnimalLittleDetailsDTO> animalsDTOLittleDetails=new LinkedList<AnimalLittleDetailsDTO>();
        for(Animal an:animals) {
            if(an.getId()!=null) {
              AnimalLittleDetailsDTO anDTOLittleDetails=AnimalLittleDetailsDTO.builder()
                        .name(an.getName())
                        .id(an.getId())
                        .description(an.getDescription())
                        .build();
                animalsDTOLittleDetails.add(anDTOLittleDetails);
            }
        }
        return animalsDTOLittleDetails;
    }


}
