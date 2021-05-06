package com.PS.demo.mapper;

import com.PS.demo.dto.MyAdminDTO;
import com.PS.demo.model.MyAdmin;

public class MyAdminMapper {
    public static MyAdminDTO mapperModelToDTO(MyAdmin myAdmin){
        MyAdminDTO myAdminDTO=new MyAdminDTO();
        myAdminDTO.setId(myAdmin.getId());
        myAdminDTO.setEmail(myAdmin.getEmail());
        myAdminDTO.setPassword(myAdmin.getPassword());
        myAdminDTO.setRole(myAdmin.getRole());
        myAdminDTO.setUsername(myAdmin.getUsername());
        myAdminDTO.setPhoneNumber(myAdmin.getPhoneNumber());
        return myAdminDTO;
    }

    public static MyAdmin mapperDTOToModel(MyAdminDTO myAdminDTO){
        MyAdmin myAdmin=new MyAdmin();
        myAdmin.setId(myAdminDTO.getId());
        myAdmin.setEmail(myAdminDTO.getEmail());
        myAdmin.setPassword(myAdminDTO.getPassword());
        myAdmin.setRole(myAdminDTO.getRole());
        myAdmin.setUsername(myAdminDTO.getUsername());
        myAdmin.setPhoneNumber(myAdminDTO.getPhoneNumber());
        return myAdmin;
    }
}
