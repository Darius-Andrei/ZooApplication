package com.PS.demo.service.impl;




import com.PS.demo.dto.MyAdminDTO;
import com.PS.demo.mapper.MyAdminMapper;
import com.PS.demo.model.MyAdmin;
import com.PS.demo.constants.Role;
import com.PS.demo.repository.MyAdminRepository;
import com.PS.demo.service.MyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class MyAdminImpl implements MyAdminService {

    @Autowired
    private MyAdminRepository myAdminRepository;

    @Override
    public List<MyAdmin> fetchAll() {
            List<MyAdmin> toRetrieve = new ArrayList<>();
            myAdminRepository.findAll().forEach(toRetrieve::add);
            return toRetrieve;
    }

    @Override
    public MyAdmin editAdmin( Long userId, MyAdminDTO ute){
        MyAdmin fetchUser = myAdminRepository.findById(userId).orElse(null);
        assert fetchUser != null;
        if (ute.getEmail() != "") {
            fetchUser.setEmail(ute.getEmail());
        }
        if(ute.getUsername()!="") {
            fetchUser.setUsername(ute.getUsername());
        }
        if(ute.getPassword()!="") {
            fetchUser.setPassword(ute.getPassword());
        }
        if(ute.getPhoneNumber()!="") {
            fetchUser.setPhoneNumber(ute.getPhoneNumber());
        }
        return myAdminRepository.save(fetchUser);
    }

    @Override
    public void deleteAdmin( Long userId){
        MyAdmin fetchUser = myAdminRepository.findById(userId).orElse(null);
        assert fetchUser != null;
        this.myAdminRepository.delete(fetchUser);
    }

    @Override
    public void addAdmin(MyAdminDTO userForm){
        MyAdmin myAdmin= MyAdminMapper.mapperDTOToModel(userForm);
        myAdmin.setRole(Role.ADMIN);
        myAdmin.setIsActive(true);
        this.myAdminRepository.save(myAdmin);
    }
}
