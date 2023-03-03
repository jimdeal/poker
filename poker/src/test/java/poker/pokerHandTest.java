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
        pokerCard card5 = new pokerCard(pokerCardsOrder.Q, pokerSuit.HEARTS);
        pokerCard card6 = new pokerCard(pokerCardsOrder.A, pokerSuit.HEARTS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);
        hand.addCardToHand(card6);

        assertTrue(hand.isCardHandFull());
        pokerCard firstCard = hand.getCard(0);
        assertEquals(firstCard, card6);
        pokerCard lastCard = hand.getCard(5);
        assertEquals(lastCard, card1);
    }

    @Test
    void getHandOrder2() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6, pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2, pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E, pokerSuit.DIAMONDS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T, pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K, pokerSuit.SPADES);
        pokerCard card6 = new pokerCard(pokerCardsOrder.T3, pokerSuit.HEARTS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);
        hand.addCardToHand(card6);

        assertTrue(hand.isCardHandFull());
        pokerCard firstCard = hand.getCard(0);
        assertEquals(firstCard, card5);
        pokerCard lastCard = hand.getCard(5);
        assertEquals(lastCard, card2);
    }

    @Test
    void testNotFullHand() {
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

        assertFalse(hand.isCardHandFull());
    }

    @Test
    void testGetNumberOfSuitsInHandALL() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6,pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2,pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E,pokerSuit.DIAMONDS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T,pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K,pokerSuit.SPADES);
        pokerCard card6 = new pokerCard(pokerCardsOrder.T3,pokerSuit.HEARTS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);
        hand.addCardToHand(card6);

        assertTrue(hand.isCardHandFull());
        assertEquals(hand.getNumberOfSuitsInHand(), 4);
    }

    @Test
    void testGetNumberOfSuitsInHandThree() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6,pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2,pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E,pokerSuit.DIAMONDS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T,pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K,pokerSuit.HEARTS);
        pokerCard card6 = new pokerCard(pokerCardsOrder.T3,pokerSuit.HEARTS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);
        hand.addCardToHand(card6);

        assertTrue(hand.isCardHandFull());
        assertEquals(hand.getNumberOfSuitsInHand(), 3);
    }

    @Test
    void testGetNumberOfSuitsInHandOne() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6,pokerSuit.CLUBS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2,pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E,pokerSuit.CLUBS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T,pokerSuit.CLUBS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K,pokerSuit.CLUBS);
        pokerCard card6 = new pokerCard(pokerCardsOrder.T3,pokerSuit.CLUBS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);
        hand.addCardToHand(card6);

        assertTrue(hand.isCardHandFull());
        assertEquals(hand.getNumberOfSuitsInHand(), 1);
    }

    @Test
    void testGetSuitWithHighestNumberOfCardsInHandFour() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6,pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2,pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E,pokerSuit.DIAMONDS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T,pokerSuit.HEARTS);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K,pokerSuit.HEARTS);
        pokerCard card6 = new pokerCard(pokerCardsOrder.T3,pokerSuit.HEARTS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);
        hand.addCardToHand(card6);

        assertTrue(hand.isCardHandFull());
        HashMap<pokerSuit, Integer> suits = hand.getNumberOfCardsInSuits();
        int numberOfHearts = suits.get(pokerSuit.HEARTS);
        assertEquals(numberOfHearts,4);
    }

    @Test
    void testGetSuitWithHighestNumberOfCardsInHandTwo() {
        pokerCard card1 = new pokerCard(pokerCardsOrder.S6,pokerSuit.HEARTS);
        pokerCard card2 = new pokerCard(pokerCardsOrder.T2,pokerSuit.CLUBS);
        pokerCard card3 = new pokerCard(pokerCardsOrder.E,pokerSuit.DIAMONDS);
        pokerCard card4 = new pokerCard(pokerCardsOrder.T,pokerSuit.SPADES);
        pokerCard card5 = new pokerCard(pokerCardsOrder.K,pokerSuit.CLUBS);
        pokerCard card6 = new pokerCard(pokerCardsOrder.T3,pokerSuit.HEARTS);

        pokerHand hand = new pokerHand();
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        hand.addCardToHand(card4);
        hand.addCardToHand(card5);
        hand.addCardToHand(card6);

        assertTrue(hand.isCardHandFull());
        HashMap<pokerSuit, Integer> suits = hand.getNumberOfCardsInSuits();
        int numberOfHearts = suits.get(pokerSuit.HEARTS);
        assertEquals(numberOfHearts,2);
        int numberOfClubs = suits.get(pokerSuit.CLUBS);
        assertEquals(numberOfClubs,2);
    }


    @Test
    void testRankHandOneSuite1() {
    }


}