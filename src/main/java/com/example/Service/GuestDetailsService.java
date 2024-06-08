package com.example.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.GuestDetails;
import com.example.Repo.GuestDetailsRepository;

@Service
public class GuestDetailsService {

    @Autowired
    private GuestDetailsRepository guestDetailsRepository;

    public List<GuestDetails> getAllGuestDetails() {
        return guestDetailsRepository.findAll();
    }

    public Optional<GuestDetails> getGuestDetailsByPanNumber(String guestDetailsId) {
        return guestDetailsRepository.findById(guestDetailsId);
    }

    public GuestDetails createGuestDetails(GuestDetails guestDetails) {
        return guestDetailsRepository.save(guestDetails);
    }

    public GuestDetails updateGuestDetails(String guestDetailsId, GuestDetails guestDetailsDetails) {
        GuestDetails guestDetails = guestDetailsRepository.findById(guestDetailsId).orElseThrow();
        guestDetails.setAadhaarNumber(guestDetailsDetails.getAadhaarNumber());
        guestDetails.setFirstName(guestDetailsDetails.getFirstName());
        guestDetails.setLastName(guestDetailsDetails.getLastName());
        guestDetails.setAddress(guestDetailsDetails.getAddress());
        guestDetails.setMobileNumber(guestDetailsDetails.getMobileNumber());
        guestDetails.setDob(guestDetailsDetails.getDob());
        guestDetails.setEmploymentYears(guestDetailsDetails.getEmploymentYears());
        guestDetails.setIsPresentlyEmployed(guestDetailsDetails.getIsPresentlyEmployed());
        guestDetails.setCompanyName(guestDetailsDetails.getCompanyName());
        guestDetails.setAnnualIncome(guestDetailsDetails.getAnnualIncome());
        guestDetails.setIncomeProofFile(guestDetailsDetails.getIncomeProofFile());
        guestDetails.setCardType(guestDetailsDetails.getCardType());
        return guestDetailsRepository.save(guestDetails);
    }

    public void deleteGuestDetails(String guestDetailsId) {
        guestDetailsRepository.deleteById(guestDetailsId);
    }
}

