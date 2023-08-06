package com.junhki.cards.controller;

import com.junhki.cards.model.Cards;
import com.junhki.cards.model.Customer;
import com.junhki.cards.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CardsController {

    private final CardsRepository cardsRepository;

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer) {
        final List<Cards> cards = this.cardsRepository.findByCustomerId(customer.getCustomerId());
        if (Objects.isNull(cards)) {
            return null;
        }
        return cards;
    }


}
