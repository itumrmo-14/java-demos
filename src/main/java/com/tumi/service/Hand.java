package com.tumi.service;

import com.tumi.model.Card;
import com.tumi.utils.PokerConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {
    Card[] hand;
    private final Deck deck;

    public Hand(){
        deck = new Deck();
    }

    public List<Card> getHand(){
        deck.shuffle();
        hand = deck.deal();
        return new ArrayList<>(Arrays.asList(hand).subList(0, PokerConstants.HAND_SIZE));
    }
}
