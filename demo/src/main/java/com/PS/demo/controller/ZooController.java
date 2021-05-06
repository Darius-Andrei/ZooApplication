package com.PS.demo.controller;

import com.PS.demo.dto.ZooDTO;
import com.PS.demo.model.Zoo;
import com.PS.demo.service.ZooService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/backend")
public class ZooController {

        @Autowired
        private ZooService zooService;

        @ApiOperation(value="Returns a list of all zoos")
        @GetMapping("/zoo")
        public ResponseEntity<List<Zoo>> fetchAll() {
            try {
                List<Zoo> toRetrieve= zooService.fetchAll();
                if(toRetrieve.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(toRetrieve, HttpStatus.OK);
            }catch(Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @ApiOperation(value="Returns an entity of the edited zoo")
        @PutMapping("/zoo/{id}")
        public ResponseEntity<Zoo> editZoo(@ApiParam(value = "Requires a zoo id")@PathVariable(value="id") Long zooId,@ApiParam(value = "Requires a zoo entity") @RequestBody ZooDTO ute) {
            this.zooService.editZoo(zooId,ute);
            return ResponseEntity.ok().build();
        }

        @ApiOperation(value="Adds a zoo to the database")
        @PostMapping("/zoo")
        public ResponseEntity addZoo(@ApiParam(value = "Requires a zoo entity")@RequestBody ZooDTO zooForm) {
            this.zooService.addZoo(zooForm);
            return ResponseEntity.ok().build();
        }

        @ApiOperation(value="Finds by id and deletes a zoo")
        @DeleteMapping("/zoo/delete/{id}")
        public ResponseEntity deleteZoo(@ApiParam(value = "Requires a zoo id")@PathVariable(value="id") Long zooId) {
            this.zooService.deleteZoo(zooId);
            return ResponseEntity.ok().build();
        }
    }
