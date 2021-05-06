package com.PS.demo.service;

import com.PS.demo.model.MyUser;
import com.PS.demo.repository.MyUserRepository;
import com.PS.demo.service.impl.MyUserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class MyUserServiceTest {
    private static final String USERNAME = "Cosmin222";
    private static final String USERNAME_NOT = "NuExist";
    private MyUserImpl myUserImpl;
    @Mock
    private MyUserRepository myUserRepository;
    private MyUser myUser;

    @BeforeEach
    void setUp(){
        initMocks(this);
        myUser = new MyUser();
        myUser.setUsername(USERNAME);
        myUser.setId(67L);
        when(myUserRepository.findByUsername(USERNAME)).thenReturn(myUser);
    }
/*
    @Test
    void givenNonExistingUser_whenCreateUser_thenAddIt() {
        myUserImpl= new MyUserImpl(myUserRepository);

        MyUser testUser=new MyUser();
        testUser.setUsername(USERNAME);
        myUserImpl.addUser(testUser);

        assertEquals(testUser.getUsername(),myUserRepository.findByUsername(testUser.getUsername()).getUsername());

    }

    @Test
    void givenExistingUser_whenDeleteUser_thenDeleteOne() {
        myUserImpl= new MyUserImpl(myUserRepository);
        System.out.println(myUser.getId()+" "+myUser.getUsername());
        myUserImpl.deleteUserTest(myUser);

        Exception exception = assertThrows(NullPointerException.class, () ->{
            myUserImpl.findByUsername(myUser.getUsername());
        });

    }

    @Test
    void givenExistingUsername_whenFindByUsername_thenFindOne() {
        myUserImpl= new MyUserImpl(myUserRepository);

        MyUser theUser= myUserImpl.findByUsername(USERNAME);

        assertNotNull(theUser);
        assertEquals(USERNAME, theUser.getUsername());
    }

    @Test
    void givenNonExistingUsername_whenFindByUsername_thenReturnException() {
        myUserImpl= new MyUserImpl(myUserRepository);

        Exception exception = assertThrows(NullPointerException.class, () ->{
            myUserImpl.findByUsername(USERNAME_NOT);
        });
    }
 */
}