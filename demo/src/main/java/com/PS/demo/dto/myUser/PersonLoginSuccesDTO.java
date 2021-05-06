package com.PS.demo.dto.myUser;

import com.PS.demo.constants.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonLoginSuccesDTO {
    private Long id;
    private Role role;
}