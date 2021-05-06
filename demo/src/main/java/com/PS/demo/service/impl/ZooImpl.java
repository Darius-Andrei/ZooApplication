package com.PS.demo.service.impl;

import com.PS.demo.dto.ZooDTO;
import com.PS.demo.mapper.ZooMapper;
import com.PS.demo.model.Zoo;
import com.PS.demo.repository.ZooRepository;
import com.PS.demo.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooImpl implements ZooService {

    @Autowired
    private ZooRepository zooRepository;

    @Override
    public List<Zoo> fetchAll() {
       return zooRepository.findAll();
    }

    @Override
    public Zoo editZoo( Long zooId, ZooDTO ute) {
        Zoo fetchZoo=zooRepository.findById(zooId).orElse(null);
        assert fetchZoo !=null;
        if(ute.getZooMap()!=null){
            fetchZoo.setZooMap(ute.getZooMap());
        }
        if(ute.getCapacity()!=null){
            fetchZoo.setCapacity(ute.getCapacity());
        }
        return zooRepository.save(fetchZoo);
    }

    @Override
    public void addZoo( ZooDTO zooFormDTO) {
        Zoo zooForm= ZooMapper.mapperDTOToZoo(zooFormDTO);
        zooForm.setCapacity(100);
        this.zooRepository.save(zooForm);
    }

    @Override
    public void deleteZoo(Long zooId) {
        Zoo fetchZoo = zooRepository.findById(zooId).orElse(null);
        assert fetchZoo != null;
        this.zooRepository.delete(fetchZoo);
    }
}
