package com.PS.demo.controller;

import com.PS.demo.dto.animal.AnimalDTO;
import com.PS.demo.mapper.AnimalMapper;
import com.PS.demo.model.Animal;
import com.PS.demo.service.AnimalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/backend")
public class AnimalController {


    @Autowired
    private AnimalService animalService;

    @ApiOperation(value="Returns a list of all animals")
    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> fetchAll() {
        try {
            List<Animal> toRetrieve = animalService.fetchAll();
            if(toRetrieve.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(toRetrieve, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value="Returns an entity of the edited animal")
    @PutMapping("/animals/{id}")
    public ResponseEntity editAnimal(@ApiParam(value = "Requires an animal id")@PathVariable(value = "id") Long animalId, @RequestBody AnimalDTO dto){
        animalService.editAnimal(animalId,dto);
        return ResponseEntity.ok().build();
    }
    @ApiOperation(value="Finds by id and deletes an animal")
    @DeleteMapping("/animals/delete/{id}")
    public ResponseEntity deleteAnimal(@ApiParam(value = "Requires an animal id")@PathVariable(value = "id") Long animalId){
        animalService.deleteAnimal(animalId);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Adds an animal to the database")
    @PostMapping("/animals")
    public ResponseEntity<AnimalDTO> addAnimal(@ApiParam(value = "Requires an animal entity")@RequestBody AnimalDTO animalFormDTO) throws IOException {
        Animal animal=animalService.addAnimal(animalFormDTO);
        AnimalDTO animalDTO= AnimalMapper.mapperAnimalToDTO(animal);
        return ResponseEntity.ok().body(animalDTO);
    }

    @ApiOperation(value="Adds an image to an animal in the database")
    @PostMapping("/animals/image/{id}")
    public ResponseEntity addImageToAnimal(@ApiParam(value = "Requires a valid animal id")@PathVariable(value="id") Long animalId, @ApiParam(value = "Requires an image")@RequestParam MultipartFile image) throws IOException {
        animalService.upload(animalId, image);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/animals/viewimage/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity viewImageAnimal(@PathVariable(value="id") Long animalId){
        Animal animal=animalService.findById(animalId);
        return ResponseEntity.ok().body(animal.getImage());
    }

}
