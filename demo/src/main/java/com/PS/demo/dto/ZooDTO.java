package com.PS.demo.dto;

import com.PS.demo.model.Donation;
import com.PS.demo.model.ZooMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZooDTO {
    private Long id;
    private ZooMap zooMap;
    private Integer capacity;

}
