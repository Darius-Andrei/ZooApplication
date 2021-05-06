package com.PS.demo.service.impl;

import com.PS.demo.model.MyUser;
import com.PS.demo.model.Person;
import com.PS.demo.repository.PersonRepository;
import com.PS.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonImpl implements PersonService {

    @Autowired
    public PersonRepository personRepository;

    @Override
    public List<Person> fetchAll() {
        return personRepository.findAll();
    }

    @Override
    public void deletePerson(Long personId) {
        Person bye_person=personRepository.findById(personId).orElseThrow(null);
        assert bye_person!=null;
        personRepository.delete(bye_person);
    }

    @Override
    @Transactional
    public Person findByUsername(String username) {
        return this.personRepository.findByUsername(username);
    }

}
