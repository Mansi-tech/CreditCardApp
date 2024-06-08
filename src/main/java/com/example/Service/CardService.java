package com.example.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Card;
import com.example.Repo.CardRepository;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardById(String cardType) {
        return cardRepository.findById(cardType);
    }

    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    public Card updateCard(String cardType, Card cardDetails) {
        Card card = cardRepository.findById(cardType).orElseThrow();
        card.setMaxLimit(cardDetails.getMaxLimit());
        card.setInterest(cardDetails.getInterest());
        card.setAnnualFee(cardDetails.getAnnualFee());
        return cardRepository.save(card);
    }

    public void deleteCard(String cardType) {
        cardRepository.deleteById(cardType);
    }
}
