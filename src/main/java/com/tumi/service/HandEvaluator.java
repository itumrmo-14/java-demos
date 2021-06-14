package com.tumi.service;

import com.tumi.exception.EmptyHandException;
import com.tumi.model.Card;
import com.tumi.utils.PokerConstants;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class HandEvaluator {

    private final Logger logger = Logger.getLogger(HandEvaluator.class.getName());

    public String evaluate(List<Card> hand) throws EmptyHandException {
        if(Objects.isNull(hand) || hand.isEmpty()){
            logger.info("Failed to evaluate hand because hand is null or empty");
            throw new EmptyHandException("Failed to evaluate hand because hand cannot be empty!");
        }
        if (this.royalFlush(hand) == 1) {
            return formatUserMessage("royal flush!");
        }
        else if (this.straightFlush(hand) == 1) {
            return formatUserMessage("straight flush!");
        }
        else if (this.fourOfaKind(hand) == 1) {
            return formatUserMessage("four of a kind!");
        }
        else if (this.fullHouse(hand) == 1) {
            return formatUserMessage("full house!");
        }
        else if (this.flush(hand) == 1) {
            return formatUserMessage("flush!");
        }
        else if (this.straight(hand) == 1) {
            return formatUserMessage("straight!");
        }
        else if (this.triple(hand) == 1) {
            return formatUserMessage("triple!");
        }
        else if (this.twoPairs(hand) == 1) {
            return formatUserMessage("two pairs!");
        }
        else if (this.pair(hand) == 1) {
            return formatUserMessage("a pair!");
        }
        else {
            int highCard = this.highCard(hand);
            return String.format(PokerConstants.HIGHEST_CARD_MESSAGE,highCard);
        }
    }

    private String formatUserMessage(String cardRank){
        return String.format(PokerConstants.MESSAGE_PATTERN,cardRank);
    }

    private int royalFlush(List<Card> hand) {
        if (hand.get(0).getRank() == 1 && hand.get(1).getRank() == 10 && hand.get(2).getRank() == 11 && hand.get(3).getRank() == 12 && hand.get(4).getRank() == 13) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private int straightFlush(List<Card> hand)
    {
        for (int counter = 1; counter < hand.size(); counter++)
        {
            if (hand.get(0).getSuit() != hand.get(counter).getSuit())
            {
                return 0;
            }
        }
        for (int counter2 = 1; counter2 < hand.size(); counter2++) {
            if (hand.get(counter2 - 1).getRank() != (hand.get(counter2).getRank() - 1)) {
                return 0;
            }

        }
        return 1;
    }

    private int fourOfaKind(List<Card> hand) {
        if (hand.get(0).getRank() != hand.get(3).getRank() && hand.get(1).getRank() != hand.get(4).getRank()) {
            return 0;
        }
        else {
            return 1;
        }
    }

    private int fullHouse(List<Card> hand) {
        int comparison = 0;
        for (int counter = 1; counter < 5; counter++) {
            if (hand.get(counter - 1).getRank() == hand.get(counter).getRank()) {
                comparison++;
            }
        }
        if (comparison == 3) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private int flush(List<Card> hand) {
        for (int counter = 1; counter < 5; counter++) {
            if (hand.get(0).getSuit() != hand.get(counter).getSuit()) {
                return 0;
            }
        }
        return 1;
    }

    private int straight(List<Card> hand) {
        for (int counter2 = 1; counter2 < 5; counter2++) {
            if (hand.get(counter2 - 1).getRank() != (hand.get(counter2).getRank()- 1)) {
                return 0;
            }

        }
        return 1;
    }

    private int triple(List<Card> hand) {
        if (hand.get(0).getRank() == hand.get(2).getRank() || hand.get(2).getRank() == hand.get(4).getRank()) {
            return 1;
        }
        return 0;
    }

    private int twoPairs(List<Card> hand) {
        int check = 0;
        for(int counter = 1; counter < 5; counter++) {
            if (hand.get(counter - 1).getRank() == hand.get(counter).getRank()) {
                check++;
            }
        }
        if (check == 2) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private int pair(List<Card> hand) {
        int check = 0;
        for(int counter = 1; counter < 5; counter++) {
            if (hand.get(counter - 1).getRank() == hand.get(counter).getRank()) {
                check++;
            }
        }
        if (check == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private int highCard(List<Card> hand) {
        int highCard = 0;
        for (int counter = 0; counter < 5; counter++) {
            if (hand.get(counter).getRank() > highCard) {
                highCard = hand.get(counter).getRank();
            }
        }
        return highCard;
    }
}
