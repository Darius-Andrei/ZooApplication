package com.PS.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ZooMap {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(targetEntity = Animal.class, mappedBy="zooMap", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    @Setter @Getter
    private List<Animal> animals;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name="zooId")
    private Zoo zoo;

    private String url;
}
