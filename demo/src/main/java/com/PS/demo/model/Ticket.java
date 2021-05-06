package com.PS.demo.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket extends PurchasableItem{
    public Ticket(Long id, String type, Double price){
        super(id,type,price);
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;



}
