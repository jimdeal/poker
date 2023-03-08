package poker;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class pokerHandTest {

    @Test
    void getHandOrder1() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.T2, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.F5, pokerSuit.HEARTS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.T3, pokerSuit.HEARTS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.N, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.A, pokerSuit.HEARTS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        pokerCard firstCard = hand.getCard(0);
        assertEquals(firstCard, card5);
        pokerCard lastCard = hand.getCard(4);
        assertEquals(lastCard, card1);
    }

    @Test
    void getHandOrder2() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E, pokerSuit.DIAMONDS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K, pokerSuit.SPADES);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);


        assertTrue(hand.isCardHandFull());
        pokerCard firstCard = hand.getCard(0);
        assertEquals(firstCard, card5);
        pokerCard lastCard = hand.getCard(4);
        assertEquals(lastCard, card2);
    }

    @Test
    void testNotFullHand() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E, pokerSuit.DIAMONDS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T, pokerSuit.HEARTS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);

        assertFalse(hand.isCardHandFull());
    }

    @Test
    void testGetNumberOfSuitsInHandALL() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E, pokerSuit.DIAMONDS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K, pokerSuit.SPADES);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        assertEquals(hand.getNumberOfSuitsInHand(), 4);
    }

    @Test
    void testGetNumberOfSuitsInHandThree() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E, pokerSuit.DIAMONDS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K, pokerSuit.HEARTS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        assertEquals(hand.getNumberOfSuitsInHand(), 3);
    }

    @Test
    void testGetNumberOfSuitsInHandOne() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6, pokerSuit.CLUBS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E, pokerSuit.CLUBS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T, pokerSuit.CLUBS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K, pokerSuit.CLUBS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        assertEquals(hand.getNumberOfSuitsInHand(), 1);
    }

    @Test
    void testGetSuitWithHighestNumberOfCardsInHandFour() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E, pokerSuit.DIAMONDS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K, pokerSuit.HEARTS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        HashMap<pokerSuit, Integer> suits = hand.getNumberOfCardsInSuits();
        int numberOfHearts = suits.get(pokerSuit.HEARTS);
        assertEquals(numberOfHearts, 3);
    }

    @Test
    void testGetSuitWithHighestNumberOfCardsInHandTwo() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E, pokerSuit.DIAMONDS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K, pokerSuit.CLUBS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        HashMap<pokerSuit, Integer> suits = hand.getNumberOfCardsInSuits();
        int numberOfHearts = suits.get(pokerSuit.HEARTS);
        assertEquals(numberOfHearts, 2);
        int numberOfClubs = suits.get(pokerSuit.CLUBS);
        assertEquals(numberOfClubs, 2);
    }


    @Test
    void testRankHandOneSuiteStraightFlush() {
        pokerCard card4 = new pokerCard(pokerCardsOrder.S6, pokerSuit.CLUBS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.T3, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.F5, pokerSuit.CLUBS);
        pokerCard card1 = new pokerCard(pokerCardsOrder.F4, pokerSuit.CLUBS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        assertEquals(hand.getNumberOfSuitsInHand(), 1);

        hand.processHand();
        assertEquals(pokerHands.STRAIGHT_FLUSH, hand.getHandResult().handName);
        assertEquals(pokerCardsOrder.S6, hand.getHandResult().firstHighVal);
    }

    @Test
    void testRankHandOneSuiteFlush() {
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card1 = new pokerCard(pokerCardsOrder.F4, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.F5, pokerSuit.CLUBS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.S6, pokerSuit.CLUBS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.E, pokerSuit.CLUBS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        assertEquals(hand.getNumberOfSuitsInHand(), 1);

        hand.processHand();
        assertEquals(pokerHands.FLUSH, hand.getHandResult().handName);
        assertEquals(pokerCardsOrder.E, hand.getHandResult().firstHighVal);
    }

    @Test
    void testRankHandTwoSuiteOnePair() {
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card1 = new pokerCard(pokerCardsOrder.T2, pokerSuit.HEARTS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.F5, pokerSuit.CLUBS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.S6, pokerSuit.CLUBS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.E, pokerSuit.CLUBS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        hand.processHand();
        assertEquals(pokerHands.PAIR, hand.getHandResult().handName);
        assertEquals(pokerCardsOrder.T2, hand.getHandResult().firstHighVal);
    }

    @Test
    void testRankHandTwoSuiteTwoPair() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.T2, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.F5, pokerSuit.CLUBS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.F5, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.E, pokerSuit.CLUBS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        hand.processHand();
        pokerHandResult result = hand.getHandResult();

        assertEquals(pokerHands.TWO_PAIRS, hand.getHandResult().handName);
        assertEquals(pokerCardsOrder.F5, hand.getHandResult().firstHighVal);
        assertEquals(pokerCardsOrder.T2, hand.getHandResult().secondHighVal);
    }

    @Test
    void testRankHandTwoAndThree() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.T2, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.F5, pokerSuit.CLUBS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.F5, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.F5, pokerSuit.DIAMONDS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        hand.processHand();

        assertEquals(pokerHands.FULL_HOUSE, hand.getHandResult().handName);
        assertEquals(pokerCardsOrder.F5, hand.getHandResult().firstHighVal);
        assertEquals(pokerCardsOrder.T2, hand.getHandResult().secondHighVal);
    }

    @Test
    void testRankHandThreeSuite() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.T2, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.E, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.F5, pokerSuit.CLUBS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.F5, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.F5, pokerSuit.DIAMONDS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        hand.processHand();

        assertEquals(pokerHands.THREE_OF_A_KIND, hand.getHandResult().handName);
        assertEquals(pokerCardsOrder.F5, hand.getHandResult().firstHighVal);
    }

    @Test
    void testRankHandFourSuite() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.T2, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.F5, pokerSuit.SPADES);
        pokerCard card3 = new pokerCard(pokerCardsOrder.F5, pokerSuit.CLUBS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.F5, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.F5, pokerSuit.DIAMONDS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        hand.processHand();

        assertEquals(pokerHands.FOUR_OF_A_KIND, hand.getHandResult().handName);
        assertEquals(pokerCardsOrder.F5, hand.getHandResult().firstHighVal);
    }

    @Test
    void testRankHandForStraight() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.T2, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T3, pokerSuit.SPADES);
        pokerCard card3 = new pokerCard(pokerCardsOrder.F4, pokerSuit.CLUBS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.F5, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.S6, pokerSuit.DIAMONDS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        hand.processHand();

        assertEquals(pokerHands.STRAIGHT, hand.getHandResult().handName);
        assertEquals(pokerCardsOrder.S6, hand.getHandResult().firstHighVal);
    }

    @Test
    void testRankHandForHighHand() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.T2, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.F4, pokerSuit.SPADES);
        pokerCard card3 = new pokerCard(pokerCardsOrder.F5, pokerSuit.CLUBS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.S7, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.N, pokerSuit.DIAMONDS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);

        assertTrue(hand.isCardHandFull());
        hand.processHand();

        assertEquals(pokerHands.HIGH_CARD, hand.getHandResult().handName);
    }

    @Test
    void testGameStraightFlush() {
    }

    @Test
    void testGameFlush() {
    }



}