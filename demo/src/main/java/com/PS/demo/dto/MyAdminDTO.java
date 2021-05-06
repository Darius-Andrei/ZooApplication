package com.PS.demo.dto;

import com.PS.demo.constants.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyAdminDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private Role role;

}
