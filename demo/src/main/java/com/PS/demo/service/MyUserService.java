package com.PS.demo.service;

import com.PS.demo.dto.myUser.MyUserDTO;
import com.PS.demo.model.MyUser;
import com.PS.demo.model.Person;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Component
public interface MyUserService {
    List<MyUser> fetchAll();
    void editUser(Long id, MyUserDTO ute);
    void addUser(MyUserDTO userForm, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException;
    void deleteUser(Long id);
    MyUser findByUsername(String username);
    void deleteUserTest(MyUser user);
    void addUserTest(MyUser user);
    Boolean activateAccount(String code);
}
