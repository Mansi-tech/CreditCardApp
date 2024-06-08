package com.example.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.GuestDetails;
import com.example.Service.GuestDetailsService;

@RestController
@RequestMapping("/api/guestdetails")
public class GuestDetailsController {

    @Autowired
    private GuestDetailsService guestDetailsService;

    @GetMapping("/readAll")
    public List<GuestDetails> getAllGuestDetails() {
        return guestDetailsService.getAllGuestDetails();
    }

    //bhencho path var se pan number thodi jaayega
    @GetMapping("/readOne/{guestDetailsId}")
    public ResponseEntity<GuestDetails> getGuestDetailsByPanNumber(@PathVariable String guestDetailsId) {
        return guestDetailsService.getGuestDetailsByPanNumber(guestDetailsId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public GuestDetails createGuestDetails(@RequestBody GuestDetails guestDetails) {
        return guestDetailsService.createGuestDetails(guestDetails);
    }

    @PutMapping("/update/{guestDetailsId}")
    public ResponseEntity<GuestDetails> updateGuestDetails(@PathVariable String guestDetailsId, @RequestBody GuestDetails guestDetailsDetails) {
        return ResponseEntity.ok(guestDetailsService.updateGuestDetails(guestDetailsId, guestDetailsDetails));
    }

    @DeleteMapping("/delete/{guestDetailsId}")
    public ResponseEntity<Void> deleteGuestDetails(@PathVariable String guestDetailsId) {
        guestDetailsService.deleteGuestDetails(guestDetailsId);
        return ResponseEntity.noContent().build();
    }
}
