package com.PS.demo.repository;

import com.PS.demo.model.ZooMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooMapRepository extends JpaRepository<ZooMap, Long> {
}
