package com.PS.demo.mapper;

import com.PS.demo.dto.TicketDTO;
import com.PS.demo.model.Ticket;

public class TicketMapper {
    public static TicketDTO mapperModelToDTO(Ticket ticket){
        TicketDTO ticketDTO=new TicketDTO();
        ticketDTO.setDate(ticket.getDate());
        ticketDTO.setId(ticket.getId());
        ticketDTO.setMyUser(ticket.getMyUser());
        ticketDTO.setPrice(ticket.getPrice());
        ticketDTO.setName(ticket.getName());
        ticketDTO.setToExpose(ticket.getToExpose());
        return ticketDTO;
    }

    public static Ticket mapperDTOToModel(TicketDTO ticketDTO){
        Ticket ticket=new Ticket();
        ticket.setDate(ticketDTO.getDate());
        ticket.setId(ticketDTO.getId());
        ticket.setMyUser(ticketDTO.getMyUser());
        ticket.setPrice(ticketDTO.getPrice());
        ticket.setName(ticketDTO.getName());
        ticket.setToExpose(ticketDTO.getToExpose());
        return ticket;
    }
}
