package com.PS.demo.mapper;

import com.PS.demo.dto.myUser.PersonCredentialsDTO;
import com.PS.demo.dto.myUser.MyUserDTO;
import com.PS.demo.dto.myUser.PersonLoginSuccesDTO;
import com.PS.demo.model.MyUser;
import com.PS.demo.model.Person;

public class MyUserMapper {
    public static MyUserDTO mapperModelToDTO(MyUser myUser){
        MyUserDTO myUserDTO=new MyUserDTO();
        myUserDTO.setId(myUser.getId());
        myUserDTO.setEmail(myUser.getEmail());
        myUserDTO.setPassword(myUser.getPassword());
        myUserDTO.setRole(myUser.getRole());
        myUserDTO.setUsername(myUser.getUsername());
        myUserDTO.setPhoneNumber(myUser.getPhoneNumber());
        myUserDTO.setItems(myUser.getItems());
        return myUserDTO;
    }

    public static MyUser mapperDTOToModel(MyUserDTO myUserDTO){
        MyUser myUser=new MyUser();
        myUser.setId(myUserDTO.getId());
        myUser.setEmail(myUserDTO.getEmail());
        myUser.setPassword(myUserDTO.getPassword());
        myUser.setRole(myUserDTO.getRole());
        myUser.setUsername(myUserDTO.getUsername());
        myUser.setPhoneNumber(myUserDTO.getPhoneNumber());
        myUser.setItems(myUserDTO.getItems());
        return myUser;
    }

    public static PersonCredentialsDTO mapperModelToCredentialsDTO(Person person){
        PersonCredentialsDTO personCredentialsDTO =new PersonCredentialsDTO();
        personCredentialsDTO.setUsername(person.getUsername());
        personCredentialsDTO.setPassword(person.getPassword());
        return personCredentialsDTO;
    }

    public static PersonLoginSuccesDTO mapperModelToLoginSuccesDTO(Person person){
        PersonLoginSuccesDTO personLoginSuccesDTO =new PersonLoginSuccesDTO();
        personLoginSuccesDTO.setId(person.getId());
        personLoginSuccesDTO.setRole(person.getRole());
        return personLoginSuccesDTO;
    }
}