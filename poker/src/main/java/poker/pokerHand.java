package poker;

import java.util.*;

public class pokerHand {

    private Set<pokerCard> hand = new TreeSet<>();

    public pokerHand(){}
    private pokerHand(Set<pokerCard> hand){};
    private pokerHand(pokerCardsOrder number, pokerSuit suit){};

    public void addCardToHand(pokerCard card){
        hand.add(card);
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
        return 0;
    }
}
