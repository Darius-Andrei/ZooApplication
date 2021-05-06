package com.PS.demo.controller;


import com.PS.demo.dto.MyAdminDTO;
import com.PS.demo.model.MyAdmin;
import com.PS.demo.service.MyAdminService;
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
public class MyAdminController {

    @Autowired
    private MyAdminService myAdminService;

    @ApiOperation(value="Returns an entity of the edited admin")
    @PutMapping("/admins/{id}")
    public ResponseEntity<MyAdmin> editAdmin(@ApiParam(value = "Requires an admin id")@PathVariable(value = "id") Long userId,@ApiParam(value = "Requires an admin entity") @RequestBody MyAdminDTO ute){
        myAdminService.editAdmin(userId,ute);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Adds an admin to the database")
    @PostMapping("/admins")
    public ResponseEntity<MyAdmin> addAdmin(@ApiParam(value = "Requires an admin entity")@RequestBody MyAdminDTO userForm){
        this.myAdminService.addAdmin(userForm);
        return ResponseEntity.ok().build();
    }

}
