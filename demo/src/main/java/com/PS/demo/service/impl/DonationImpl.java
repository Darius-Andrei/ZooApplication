package com.PS.demo.service.impl;

import com.PS.demo.dto.DonationDTO;
import com.PS.demo.mapper.DonationMapper;
import com.PS.demo.model.Donation;
import com.PS.demo.model.MyUser;
import com.PS.demo.repository.DonationRepository;
import com.PS.demo.repository.MyUserRepository;
import com.PS.demo.repository.TicketRepository;
import com.PS.demo.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationImpl implements DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public List<Donation> fetchAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation editDonation(Long donationId, DonationDTO ute) {
        Donation fetchDonation= donationRepository.findById(donationId).orElse(null);
        assert fetchDonation!=null;
        if(ute.getName()!=null)
        {
            fetchDonation.setName(ute.getName());
        }
        if(ute.getPrice()!=null)
        {
            fetchDonation.setPrice(ute.getPrice());
        }
        if(ute.getDescription()!=null)
        {
            fetchDonation.setDescription(ute.getDescription());
        }
        return donationRepository.save(fetchDonation);
    }

    @Override
    public void addDonation(DonationDTO donationFormDTO) {
        Donation donationForm= DonationMapper.mapperDTOToModel(donationFormDTO);
        donationForm.setToExpose(true);
        this.donationRepository.save(donationForm);
    }

    @Override
    public void deleteDonation(Long donationId) {
        Donation donationForm=donationRepository.findById(donationId).orElse(null);
        assert donationForm!=null;
        this.donationRepository.delete(donationForm);
    }

    @Override
    public void addDonationAndSetUser(DonationDTO donationFormDTO, String myUserUsername) {
        MyUser userDonation= myUserRepository.findByUsername(myUserUsername);
        Donation donationForm=DonationMapper.mapperDTOToModel(donationFormDTO);
        donationForm.setId(null);
        donationForm.setMyUser(userDonation);
        donationForm.setToExpose(false);
        this.donationRepository.save(donationForm);

    }
}
