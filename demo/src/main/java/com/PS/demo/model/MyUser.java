package com.PS.demo.model;

import com.PS.demo.constants.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class MyUser extends Person{
    public MyUser(){}
    public MyUser(Long id, String username, String password, String email, String phoneNumber, List<PurchasableItem> items) {
        super(id, username, password, email, phoneNumber, false, null);
        this.setRole(Role.USER);
        this.items = items;
    }

    @OneToMany(targetEntity = PurchasableItem.class, mappedBy="myUser", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
    private List<PurchasableItem> items;


}
