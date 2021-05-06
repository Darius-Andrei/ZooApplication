package com.PS.demo.controller;

import com.PS.demo.dto.ZooMapDTO;
import com.PS.demo.model.ZooMap;
import com.PS.demo.service.ZooMapService;
import io.swagger.annotations.Api;
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
public class ZooMapController {


        @Autowired
        private ZooMapService zooMapService;

        @ApiOperation(value="Returns a list of all zooMaps")
        @GetMapping("/zooMap")
        public ResponseEntity fetchAll() {
            try {
                List<ZooMap> toRetrieve = zooMapService.fetchAll();
                if(toRetrieve.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity(toRetrieve, HttpStatus.OK);
            }catch(Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @ApiOperation(value="Returns an entity of the edited zooMap")
        @PutMapping("zooMap/{id}")
        public ResponseEntity editZooMap(@ApiParam(value = "Requires a zooMAp id")@PathVariable(value="id") Long zooMapId, ZooMapDTO ute) {
            this.zooMapService.editZooMap(zooMapId,ute);
            return ResponseEntity.ok().build();
        }

        @ApiOperation(value="Adds a zooMap to the database")
        @PostMapping("/zooMap")
        public ResponseEntity addZooMap(@ApiParam(value = "Requires a zooMap entity")@RequestBody ZooMapDTO zooMapForm) {
            this.zooMapService.addZooMap(zooMapForm);
            return ResponseEntity.ok().build();
        }

        @ApiOperation(value="Finds by id and deletes an animal")
        @DeleteMapping("/zooMap/delete/{id}")
        public ResponseEntity deleteZooMap(@ApiParam(value = "Requires a zooMap id")@PathVariable(value="id") Long zooMapId) {
            this.zooMapService.deleteZooMap(zooMapId);
            return ResponseEntity.ok().build();
        }
    }

