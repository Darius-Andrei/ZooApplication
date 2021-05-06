package com.PS.demo.service;


import com.PS.demo.dto.ZooMapDTO;
import com.PS.demo.model.ZooMap;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ZooMapService {
    List<ZooMap> fetchAll();
    ZooMap editZooMap(Long id, ZooMapDTO ute);
    void addZooMap(ZooMapDTO zooMapForm);
    void deleteZooMap(Long id);
}