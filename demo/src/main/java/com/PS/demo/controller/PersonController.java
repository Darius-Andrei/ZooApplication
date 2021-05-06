package com.PS.demo.controller;

import com.PS.demo.dto.myUser.PersonCredentialsDTO;
import com.PS.demo.model.MyUser;
import com.PS.demo.model.Person;
import com.PS.demo.service.MyUserService;
import com.PS.demo.service.PersonService;
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

public class PersonController {

    @Autowired
    public PersonService personService;

    @Autowired
    public MyUserService myUserService;

    @ApiOperation(value="Returns a list of all persons")
    @GetMapping("/users")
    public ResponseEntity fetchAll() {
        try {
            List<Person> toRetrieve =personService.fetchAll();
            if(toRetrieve.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(toRetrieve, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value="Returns the user in the database that has the coresponding username")
    @GetMapping("/user/{username}")
    public ResponseEntity getUserByUsername(@ApiParam(value = "Requires a person username")@PathVariable(value="username") String username) {
        try {
            MyUser toRetrieve= myUserService.findByUsername(username);

            if(toRetrieve==null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(toRetrieve, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @ApiOperation(value="Generates the atributtes for the local storage login")
    @PostMapping("/login")
    public ResponseEntity login(@ApiParam(value = "Requires a person entity")@RequestBody PersonCredentialsDTO p) {
        try{
            Person toLogin= personService.findByUsername(p.getUsername());
            System.out.println(toLogin);
            System.out.println(p.getPassword());
            if(toLogin==null){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            if(!toLogin.getPassword().equals(p.getPassword()))
            {
                System.out.println("nu intru aci?");
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            if(toLogin.getIsActive()==false){
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }

            return ResponseEntity.ok().body(toLogin);
        }
        catch(Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ApiOperation(value="Finds by id and deletes a person")
    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity deleteUser(@ApiParam(value = "Requires a person id")@PathVariable(value = "id") Long userId){
        this.personService.deletePerson(userId);
        return ResponseEntity.ok().build();
    }

}
