package com.PS.demo.service.impl;


import com.PS.demo.dto.TicketDTO;
import com.PS.demo.mapper.TicketMapper;
import com.PS.demo.model.MyUser;
import com.PS.demo.model.Ticket;
import com.PS.demo.repository.MyUserRepository;
import com.PS.demo.repository.PersonRepository;
import com.PS.demo.repository.TicketRepository;
import com.PS.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TicketImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MyUserRepository myUserRepository;


    @Override
    public List<Ticket> fetchAll() {
            return ticketRepository.findAll();
    }

    @Override
    public Ticket editTicket(Long ticketId, TicketDTO ute) {
        Ticket fetchTicket= ticketRepository.findById(ticketId).orElse(null);
        assert fetchTicket!=null;
        if(ute.getDate()!=null)
        {
            fetchTicket.setDate(ute.getDate());
        }
        if(ute.getPrice()!=null)
        {
            fetchTicket.setPrice(ute.getPrice());
        }
        if(ute.getName()!="")
        {
            fetchTicket.setName(ute.getName());
        }
        return ticketRepository.save(fetchTicket);
    }


    @Override
    public void addTicket( TicketDTO ticketFormDTO) {
        Ticket ticketForm= TicketMapper.mapperDTOToModel(ticketFormDTO);
        ticketForm.setToExpose(true);
        this.ticketRepository.save(ticketForm);
    }

    @Override
    public void deleteTicket(Long ticketId) {
        Ticket fetchTicket= ticketRepository.findById(ticketId).orElse(null);
        assert fetchTicket != null;
        this.ticketRepository.delete(fetchTicket);
    }

    @Override
    public void addTicketAndSetUser(TicketDTO ticketFormDTO, String myUserUsername) {
        MyUser userTicket= myUserRepository.findByUsername(myUserUsername);
        Ticket ticketForm= TicketMapper.mapperDTOToModel(ticketFormDTO);
        ticketForm.setId(null);
        ticketForm.setMyUser(userTicket);
        ticketForm.setToExpose(false);

        this.ticketRepository.save(ticketForm);


    }
}
