package com.PS.demo.service;

import com.PS.demo.model.Animal;
import com.PS.demo.model.PurchasableItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PurchasableItemService {
    List<PurchasableItem> fetchAll();
}
