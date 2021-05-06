package com.PS.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Zoo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(targetEntity = ZooMap.class, mappedBy = "zoo", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
    private ZooMap zooMap;


    private Integer capacity;
}
