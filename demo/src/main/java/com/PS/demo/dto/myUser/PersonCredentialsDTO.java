package com.PS.demo.dto.myUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonCredentialsDTO {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
}
