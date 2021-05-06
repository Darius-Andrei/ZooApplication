package com.PS.demo.mapper;

import com.PS.demo.dto.ZooDTO;
import com.PS.demo.model.Zoo;

public class ZooMapper {
    public static ZooDTO mapperModelToDTO(Zoo zoo){
        ZooDTO zooDTO=new ZooDTO();
        zooDTO.setZooMap(zoo.getZooMap());
        zooDTO.setId(zoo.getId());
        zooDTO.setCapacity(zoo.getCapacity());
        return zooDTO;
    }

    public static Zoo mapperDTOToZoo(ZooDTO zooDTO){
        Zoo zoo=new Zoo();
        zoo.setZooMap(zooDTO.getZooMap());
        zoo.setId(zooDTO.getId());
        zoo.setCapacity(zooDTO.getCapacity());
        return zoo;
    }

}
