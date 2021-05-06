package com.PS.demo.dto;

import com.PS.demo.model.MyUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private Long id;
    private Double price;
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    private MyUser myUser;
    private Boolean toExpose;
}
