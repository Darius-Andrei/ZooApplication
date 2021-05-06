package com.PS.demo.service;

import com.PS.demo.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> fetchAll();
    void deletePerson(Long personId);
    Person findByUsername(String username);
}
