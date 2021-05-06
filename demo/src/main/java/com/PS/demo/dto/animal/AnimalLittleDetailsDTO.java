package com.PS.demo.dto.animal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnimalLittleDetailsDTO {
    private Long id;
    private String name;
    private String description;
}
