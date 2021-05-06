package com.PS.demo.service;

import com.PS.demo.dto.DonationDTO;
import com.PS.demo.model.Donation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DonationService {
    List<Donation> fetchAll();
    Donation editDonation(Long id, DonationDTO ute);
    void addDonation( DonationDTO DonationForm);
    void deleteDonation(Long id);
    void addDonationAndSetUser(DonationDTO DonationForm, String myUserUsername);
}
