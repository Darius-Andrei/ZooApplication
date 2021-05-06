package com.PS.demo.service;


import com.PS.demo.dto.ZooDTO;
import com.PS.demo.model.Zoo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ZooService {
    List<Zoo> fetchAll();
    Zoo editZoo(Long id, ZooDTO ute);
    void addZoo(ZooDTO zooForm);
    void deleteZoo(Long id);
}
