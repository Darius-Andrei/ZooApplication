package com.PS.demo.service.impl;

import com.PS.demo.dto.animal.AnimalDTO;
import com.PS.demo.mapper.AnimalMapper;
import com.PS.demo.model.*;
import com.PS.demo.repository.AnimalRepository;
import com.PS.demo.repository.ZooMapRepository;
import com.PS.demo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class AnimalImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ZooMapRepository zooMapRepository;

    @Override
    public List<Animal> fetchAll() {
        List<Animal> toRetrieve = new ArrayList<>();
        animalRepository.findAll().forEach(toRetrieve::add);
        return toRetrieve;
    }

    @Override
    public Animal editAnimal(Long animalId, AnimalDTO dto){
        Animal animal = animalRepository.findById(animalId).orElse(null);
        assert animal != null;

        if (dto.getName() != "") {
            animal.setName(dto.getName());
        }
        if(dto.getAnimalClass()!="") {
            animal.setAnimalClass(dto.getAnimalClass());
        }
        if(dto.getAnimalFamily()!="") {
            animal.setAnimalFamily(dto.getAnimalFamily());
        }
        if(dto.getAnimalOrder()!="") {
            animal.setAnimalOrder(dto.getAnimalOrder());
        }
        if(dto.getAnimalGenusAndSpecies()!="") {
            animal.setAnimalGenusAndSpecies(dto.getAnimalGenusAndSpecies());
        }
        if(dto.getDescription()!="") {
            animal.setDescription(dto.getDescription());
        }
        return animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal( Long animalId){
        Animal animal = animalRepository.findById(animalId).orElse(null);
        assert animal != null;
        this.animalRepository.delete(animal);
    }

    @Override
    public Animal addAnimal(AnimalDTO animalFormDTO) throws IOException {
        Animal animalForm=AnimalMapper.mapperDTOToAnimal(animalFormDTO);
        List<ZooMap> zooMaps=zooMapRepository.findAll();
        animalForm.setZooMap(zooMaps.get(0));
        return this.animalRepository.save(animalForm);
    }

    @Override
    @Transactional
    public void upload(Long animalId, MultipartFile image) throws IOException {
        Animal animalForm= animalRepository.findById(animalId).orElse(null);
        animalForm.setImage(image.getBytes());
        this.animalRepository.save(animalForm);
    }

    @Override
    public Animal findById(Long animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }


}
