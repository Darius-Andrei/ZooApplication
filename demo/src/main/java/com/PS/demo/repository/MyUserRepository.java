package com.PS.demo.repository;

import com.PS.demo.model.MyUser;
import com.PS.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);
    MyUser findByToken(String token);
}
