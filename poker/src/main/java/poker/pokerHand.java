package poker;

import java.util.*;

public class pokerHand {


    private Set<pokerCard> hand = new TreeSet<pokerCard>();
    private  HashMap<pokerSuit, Integer> handBySuite = new HashMap<pokerSuit, Integer>();

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
        return (hand.size() == 6);
    }

    public pokerCard getCard(int cardIndex){
        pokerCard returnedCard = null;
        if(cardIndex>=0 && cardIndex<=5){
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


}
