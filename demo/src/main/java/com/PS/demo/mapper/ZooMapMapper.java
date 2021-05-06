package com.PS.demo.mapper;

import com.PS.demo.dto.ZooMapDTO;
import com.PS.demo.model.ZooMap;

public class ZooMapMapper {
    public static ZooMapDTO mapperModelToDTO(ZooMap zooMap){
        ZooMapDTO zooMapDTO= new ZooMapDTO();
        zooMapDTO.setZoo(zooMap.getZoo());
        zooMapDTO.setId(zooMap.getId());
        zooMapDTO.setAnimals(zooMap.getAnimals());
        zooMapDTO.setUrl(zooMap.getUrl());
        return zooMapDTO;
    }

    public static ZooMap mapperDTOToModel(ZooMapDTO zooMapDTO){
        ZooMap zooMap= new ZooMap();
        zooMap.setZoo(zooMapDTO.getZoo());
        zooMap.setUrl(zooMapDTO.getUrl());
        zooMap.setId(zooMapDTO.getId());
        zooMap.setAnimals(zooMapDTO.getAnimals());
        return zooMap;
    }
}
