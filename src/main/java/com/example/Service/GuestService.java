package com.example.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Guest;
import com.example.Repo.GuestRepository;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Optional<Guest> getGuestById(Long guestId) {
        return guestRepository.findById(guestId);
    }

    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest updateGuest(Long guestId, Guest guestDetails) {
        Guest guest = guestRepository.findById(guestId).orElseThrow();
        guest.setEmail(guestDetails.getEmail());
        guest.setMobileNumber(guestDetails.getMobileNumber());
        guest.setPassword(guestDetails.getPassword());
        guest.setName(guestDetails.getName());
        return guestRepository.save(guest);
    }

    public void deleteGuest(Long guestId) {
        guestRepository.deleteById(guestId);
    }
}

