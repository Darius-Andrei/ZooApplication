package com.PS.demo.controller;

import com.PS.demo.dto.TicketDTO;
import com.PS.demo.model.Ticket;
import com.PS.demo.service.TicketService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/backend")
@RestController
public class TicketController {

    @Autowired
    public TicketService ticketService;

    @ApiOperation(value="Returns a list of all ticket types")
    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> fetchAll() {
        try {
            List<Ticket> toRetrieve=ticketService.fetchAll();
            if(toRetrieve.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(toRetrieve, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ApiOperation(value="Returns an entity of the edited ticket")
    @PutMapping("/tickets/{id}")
    public ResponseEntity editTicket(@ApiParam(value = "Requires a ticket id")@PathVariable(value="id") Long ticketId,@ApiParam(value = "Requires a ticket entity") @RequestBody TicketDTO ute) {
        ticketService.editTicket(ticketId,ute);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Adds a ticket to the database")
    @PostMapping("/tickets")
    public ResponseEntity addTicket(@ApiParam(value = "Requires a ticket entity")@RequestBody TicketDTO ticketForm) {
        ticketService.addTicket(ticketForm);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Adds a ticket to a users cart")
    @PostMapping("/tickets/{username}")
    public ResponseEntity addTicketToUser(@ApiParam(value = "Requires a ticket id")@PathVariable(value="username") String myUserUsername,@ApiParam(value = "Requires a ticket entity") @RequestBody TicketDTO ticketForm) {
        ticketService.addTicketAndSetUser(ticketForm, myUserUsername );
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Finds by id and deletes a ticket")
    @DeleteMapping("/tickets/delete/{id}")
    public ResponseEntity deleteTicket(@ApiParam(value = "Requires a ticket id")@PathVariable(value = "id") Long ticketId) {
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.ok().build();
    }
}
