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

import com.example.Model.Guest;
import com.example.Service.GuestService;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping("/readAll")
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/readOne/{guestId}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long guestId) {
        return guestService.getGuestById(guestId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.createGuest(guest);
    }

    @PutMapping("/update/{guestId}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long guestId, @RequestBody Guest guestDetails) {
        return ResponseEntity.ok(guestService.updateGuest(guestId, guestDetails));
    }

    @DeleteMapping("/delete/{guestId}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long guestId) {
        guestService.deleteGuest(guestId);
        return ResponseEntity.noContent().build();
    }
}

