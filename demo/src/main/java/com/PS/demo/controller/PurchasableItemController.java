package com.PS.demo.controller;

import com.PS.demo.model.PurchasableItem;
import com.PS.demo.model.Ticket;
import com.PS.demo.service.PurchasableItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/backend")
@RestController
public class PurchasableItemController {

    @Autowired
    private PurchasableItemService purchasableItemService;

    @GetMapping("/cart")
    public ResponseEntity<List<PurchasableItem>> fetchAll(){
        try {
            List<PurchasableItem> toRetrieve=purchasableItemService.fetchAll();
            if(toRetrieve.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(toRetrieve, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
