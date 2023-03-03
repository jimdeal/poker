package poker;

import java.util.*;

public class pokerHand {
    private final int MAX_NUM_CARDS = 5;
    private final int LOWER_RANGE = 4;

    private Set<pokerCard> hand = new TreeSet<pokerCard>();
    private  HashMap<pokerSuit, Integer> handBySuite = new HashMap<pokerSuit, Integer>();
    private pokerHandResult  handRank = new pokerHandResult();

    public pokerHand(){}
    private pokerHand(Set<pokerCard> hand){};
    private pokerHand(pokerCardsOrder number, pokerSuit suit){};

    public void addCardToHand(pokerCard card){
        hand.add(card);
        if(!handBySuite.containsKey(card.suit)){
            handBySuite.put(card.suit,1);
        } else {
            Integer count = handBySuite.get(card.suit);
            handBySuite.put(card.suit,++count);
        }
    }

    public Set<pokerCard> getHand() {
        return hand;
    }

    public boolean isCardHandFull(){
        return (hand.size() == MAX_NUM_CARDS);
    }

    public pokerCard getCard(int cardIndex){
        pokerCard returnedCard = null;
        if(cardIndex>=0 && cardIndex<=MAX_NUM_CARDS){
            returnedCard = hand.stream().toList().get(cardIndex);
        }
        return returnedCard;
    }

    public int getNumberOfSuitsInHand() {
        Set<pokerSuit> tempSet = new TreeSet<pokerSuit>();
        hand.forEach( (h) -> { tempSet.add(h.suit);} );
        return tempSet.size();
    }

    public HashMap<pokerSuit, Integer> getNumberOfCardsInSuits() {
        return handBySuite;
    }


    public void processHand(){
        int numberOfSuitsInHand = this.getNumberOfSuitsInHand();

        switch (numberOfSuitsInHand){
            case 1: processOneSuite();
                break;
            default:
                break;
        }
    }

    public pokerHandResult getHandResult(){
        return this.handRank;
    }

    public boolean checkContinuousCards(){
        boolean oneDifference = true;

        for(int c = 0; c < LOWER_RANGE; c++){
            pokerCard firstCard = hand.stream().toList().get(c);
            pokerCard nextCard = hand.stream().toList().get(c+1);

            if(Math.abs(firstCard.number.ordinal() - nextCard.number.ordinal())>1){
                oneDifference = false;
                break;
            }
        }
        return oneDifference;
    }

    private void processOneSuite() {
        if(this.checkContinuousCards()){
            handRank.handName = pokerHands.STRAIGHT_FLUSH;
        } else{
            handRank.handName = pokerHands.FLUSH;
        }
        handRank.firstHighVal = hand.stream().toList().get(0).number;
        for(int r = 1; r < MAX_NUM_CARDS;r++){
            pokerCardsOrder order = hand.stream().toList().get(r).number;
            handRank.remainingValue[r-1] = order;
        }
    }
}
