package com.PS.demo.service;

import com.PS.demo.dto.MyAdminDTO;
import com.PS.demo.model.MyAdmin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MyAdminService {
    List<MyAdmin> fetchAll();
    MyAdmin editAdmin(Long id, MyAdminDTO ute);
    void addAdmin(MyAdminDTO userForm);
    void deleteAdmin(Long id);
}
