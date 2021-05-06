package com.PS.demo.service.impl;

import com.PS.demo.model.PurchasableItem;
import com.PS.demo.repository.PurchasableItemRepository;
import com.PS.demo.service.PurchasableItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasableItemImpl implements PurchasableItemService {

    @Autowired
    private PurchasableItemRepository purchasableItemRepository;

    @Override
    public List<PurchasableItem> fetchAll() {
        return purchasableItemRepository.findAll();
    }
}

