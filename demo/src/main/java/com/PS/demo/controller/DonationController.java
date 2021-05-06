package com.PS.demo.controller;

import com.PS.demo.dto.DonationDTO;
import com.PS.demo.dto.TicketDTO;
import com.PS.demo.model.Donation;
import com.PS.demo.model.Ticket;
import com.PS.demo.service.DonationService;
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
public class DonationController {

    @Autowired
    private DonationService donationService;

    @ApiOperation(value="Returns a list of all donation types")
    @GetMapping("/donations")
    public ResponseEntity<List<Donation>> fetchAll() {
        try {
            List<Donation> toRetrieve=donationService.fetchAll();
            if(toRetrieve.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(toRetrieve, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value="Returns an entity of the edited donation")
    @PutMapping("/donations/{id}")
    public ResponseEntity editDonation(@ApiParam(value = "Requires a donation id")@PathVariable(value="id") Long donationId, @ApiParam(value = "Requires a donation entity") @RequestBody DonationDTO ute) {
        donationService.editDonation(donationId,ute);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Adds a donation to the database")
    @PostMapping("/donations")
    public ResponseEntity addDonation(@ApiParam(value = "Requires a donation entity")@RequestBody DonationDTO donationForm) {
        donationService.addDonation(donationForm);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Adds a donation to a users cart")
    @PostMapping("/donations/{username}")
    public ResponseEntity addDonationToUser(@ApiParam(value = "Requires a donation id")@PathVariable(value="username") String myUserUsername,@ApiParam(value = "Requires a donation entity") @RequestBody DonationDTO donationForm) {
        donationService.addDonationAndSetUser(donationForm, myUserUsername );
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Finds by id and deletes a donation")
    @DeleteMapping("/donations/delete/{id}")
    public ResponseEntity deleteDonations(@ApiParam(value = "Requires a donation id")@PathVariable(value = "id") Long donationId) {
        donationService.deleteDonation(donationId);
        return ResponseEntity.ok().build();
    }
}
