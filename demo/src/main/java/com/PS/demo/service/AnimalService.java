package com.PS.demo.service;

import com.PS.demo.dto.animal.AnimalDTO;
import com.PS.demo.model.Animal;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public interface AnimalService {
    List<Animal> fetchAll();
    Animal editAnimal(Long id, AnimalDTO dto);
    Animal addAnimal(AnimalDTO animalFormDTO) throws IOException;
    void upload(Long id,MultipartFile image) throws IOException;
    Animal findById(Long animalId);
    void deleteAnimal(Long id);
}
