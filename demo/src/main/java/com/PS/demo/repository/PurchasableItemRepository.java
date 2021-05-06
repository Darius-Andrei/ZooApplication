package com.PS.demo.repository;

import com.PS.demo.model.PurchasableItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasableItemRepository extends JpaRepository<PurchasableItem, Long> {
}
