package com.PS.demo.mapper;

import com.PS.demo.dto.DonationDTO;
import com.PS.demo.model.Donation;

public class DonationMapper {
    public static DonationDTO mapperModelToDTO(Donation Donation){
        DonationDTO DonationDTO=new DonationDTO();
        DonationDTO.setDescription(Donation.getDescription());
        DonationDTO.setId(Donation.getId());
        DonationDTO.setMyUser(Donation.getMyUser());
        DonationDTO.setPrice(Donation.getPrice());
        DonationDTO.setName(Donation.getName());
        DonationDTO.setToExpose(Donation.getToExpose());
        return DonationDTO;
    }

    public static Donation mapperDTOToModel(DonationDTO DonationDTO){
        Donation Donation=new Donation();
        Donation.setDescription(DonationDTO.getDescription());
        Donation.setId(DonationDTO.getId());
        Donation.setMyUser(DonationDTO.getMyUser());
        Donation.setPrice(DonationDTO.getPrice());
        Donation.setName(DonationDTO.getName());
        Donation.setToExpose(DonationDTO.getToExpose());
        return Donation;
    }
}
