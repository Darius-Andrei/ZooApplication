package com.PS.demo.service.impl;


import com.PS.demo.dto.ZooMapDTO;
import com.PS.demo.mapper.ZooMapMapper;
import com.PS.demo.model.Zoo;
import com.PS.demo.model.ZooMap;
import com.PS.demo.repository.ZooMapRepository;
import com.PS.demo.repository.ZooRepository;
import com.PS.demo.service.ZooMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ZooMapImpl implements ZooMapService {

    @Autowired
    private ZooMapRepository zooMapRepository;

    @Autowired
    private ZooRepository zooRepository;

    @Override
    public List<ZooMap> fetchAll() {
        return zooMapRepository.findAll();
    }

    @Override
    public ZooMap editZooMap( Long zooMapId, ZooMapDTO ute) {
        ZooMap fetchZooMap= zooMapRepository.findById(zooMapId).orElse(null);
        assert fetchZooMap !=null;
        if(ute.getAnimals().size()!=0){
            fetchZooMap.setAnimals(ute.getAnimals());
        }
        return zooMapRepository.save(fetchZooMap);
    }

    @Override
    public void addZooMap( ZooMapDTO zooMapFormDTO) {
        ZooMap zooMapForm= ZooMapMapper.mapperDTOToModel(zooMapFormDTO);
        List <Zoo> zoos=zooRepository.findAll();
        zooMapForm.setZoo(zoos.get(0));
        zooMapForm.setUrl("https://cdnb.artstation.com/p/assets/images/images/026/286/445/large/hai-chi-zoo.jpg?1588366160");
        this.zooMapRepository.save(zooMapForm);
    }

    @Override
    public void deleteZooMap( Long zooMapId) {
        ZooMap fetchZooMap = zooMapRepository.findById(zooMapId).orElse(null);
        assert fetchZooMap!= null;
        this.zooMapRepository.delete(fetchZooMap);
    }
}
