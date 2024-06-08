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

import com.example.Model.Card;
import com.example.Service.CardService;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/readAll")
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/readOne/{cardType}")
    public ResponseEntity<Card> getCardById(@PathVariable String cardType) {
        return cardService.getCardById(cardType)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @PutMapping("/update/{cardType}")
    public ResponseEntity<Card> updateCard(@PathVariable String cardType, @RequestBody Card cardDetails) {
        return ResponseEntity.ok(cardService.updateCard(cardType, cardDetails));
    }

    @DeleteMapping("/delete/{cardType}")
    public ResponseEntity<Void> deleteCard(@PathVariable String cardType) {
        cardService.deleteCard(cardType);
        return ResponseEntity.noContent().build();
    }
}

