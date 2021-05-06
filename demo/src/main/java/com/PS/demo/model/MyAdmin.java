package com.PS.demo.model;

import com.PS.demo.constants.Role;

import javax.persistence.*;

@Entity
public class MyAdmin extends Person{
    public MyAdmin(){}
    public MyAdmin(Long id, String username, String password, String email, String phoneNumber) {
        super(id, username, password, email, phoneNumber, true, null);
        this.setRole(Role.ADMIN);
    }
}