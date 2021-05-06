package com.PS.demo.controller;


import com.PS.demo.dto.MyAdminDTO;
import com.PS.demo.dto.myUser.MyUserDTO;
import com.PS.demo.model.MyUser;
import com.PS.demo.model.Person;
import com.PS.demo.service.MyUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/backend")
public class MyUserController {

    @Autowired
    private MyUserService myUserService;

    @ApiOperation(value="Returns an entity of the edited user")
    @PutMapping("/users/{id}")
    public ResponseEntity editUser(@ApiParam(value = "Requires an user id")@PathVariable(value = "id") Long userId,@ApiParam(value = "Requires an user entity") @RequestBody MyUserDTO uteDTO){
        this.myUserService.editUser(userId, uteDTO);
        return ResponseEntity.ok().build();
    }


    @ApiOperation(value="Adds an user to the database")
    @PostMapping("/users")
    public ResponseEntity<MyUser> addUser(@ApiParam(value = "Requires an user entity")@RequestBody MyUserDTO userFormDTO, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        this.myUserService.addUser(userFormDTO,request);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Renders a new page after clicking the mail activation link")
    @GetMapping("/verify")
    public String verifyMail(@ApiParam(value = "Requires a verification code")@RequestParam String code, Model model)
    {
        boolean verified = myUserService.activateAccount(code);
        String pageTitle = verified ? "Success" : "Fail";
        model.addAttribute("pageTitle", pageTitle);
        return "Your account has been activated with succes";
    }



}
