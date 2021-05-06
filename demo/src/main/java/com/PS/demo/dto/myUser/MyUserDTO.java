package com.PS.demo.dto.myUser;

import com.PS.demo.constants.Role;
import com.PS.demo.model.PurchasableItem;
import com.PS.demo.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyUserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private Role role;
    private List<PurchasableItem> items;
}
