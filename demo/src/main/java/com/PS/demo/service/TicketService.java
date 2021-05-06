package com.PS.demo.service;

import com.PS.demo.dto.TicketDTO;
import com.PS.demo.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TicketService {
    List<Ticket> fetchAll();
    Ticket editTicket(Long id, TicketDTO ute);
    void addTicket( TicketDTO ticketForm);
    void deleteTicket(Long id);
    void addTicketAndSetUser(TicketDTO ticketForm, String myUserUsername);
}