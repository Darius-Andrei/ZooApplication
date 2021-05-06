package com.PS.demo.repository;

import com.PS.demo.model.MyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyAdminRepository extends JpaRepository<MyAdmin, Long> {
}
