package com.tumi.service;

import com.tumi.model.Card;
import com.tumi.utils.PokerConstants;

import java.util.Random;
import java.util.logging.Logger;

public class Deck {

    private final Random random = new Random();
    private final Logger logger = Logger.getLogger(Deck.class.getName());
    Card[] deck = new Card[PokerConstants.DECK_SIZE];
    private int restOfDeck = 6;

    {
        logger.info("Filling the deck with cards.......................");
        int counter = 0;
        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deck[counter] = new Card();
                deck[counter].setSuit(suit);
                deck[counter].setRank(rank);
                counter++;
            }
        }
    }

    public void shuffle() {
        for (int x = 0; x <= PokerConstants.SHUFFLE_EXCHANGES; x++) {
            int number1 = random.nextInt(PokerConstants.DECK_SIZE);
            int number2 = random.nextInt(PokerConstants.DECK_SIZE);
            Card temp = deck[number1];
            deck[number1] = deck[number2];
            deck[number2] = temp;
        }
    }

    public Card[] deal() {
        Card[] hand = new Card[PokerConstants.HAND_SIZE];
        System.arraycopy(deck, 0, hand, 0, 5);
        return hand;
    }

    public Card redeal() {
        Card nextCard = deck[restOfDeck];
        restOfDeck++;
        return nextCard;
    }

    public void refreshDeckPosition() {
        restOfDeck = 6;
    }
}
