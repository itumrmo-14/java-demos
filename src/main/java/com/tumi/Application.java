package com.tumi;

import com.tumi.exception.EmptyHandException;
import com.tumi.model.Card;
import com.tumi.service.Hand;
import com.tumi.service.HandEvaluator;

import java.util.List;
import java.util.logging.Logger;

public class Application {
    private static Logger logger = Logger.getLogger(Application.class.getName());
    public static void main(String[] args) {
        logger.info("Starting application in default port.................");
        Hand hand = new Hand();
        List<Card> localHand = hand.getHand();
        HandEvaluator handEvaluator = new HandEvaluator();
        try {
            String message = handEvaluator.evaluate(localHand);
            logger.info(message);
        } catch (EmptyHandException e) {
            e.printStackTrace();
        }
    }
}
