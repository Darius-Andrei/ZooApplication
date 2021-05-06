package com.PS.demo.dto;

import com.PS.demo.model.MyUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationDTO {
    private Long id;
    private Double price;
    private String name;
    private String description;
    private MyUser myUser;
    private Boolean toExpose;

}
