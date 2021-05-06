package com.PS.demo.model;
import com.PS.demo.constants.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private Role role;
    private Boolean isActive;
    private String token;

    public Person(Long id, String username, String password, String email, String phoneNumber, Boolean isActive, String token) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isActive=isActive;
        this.token=token;
    }
}
