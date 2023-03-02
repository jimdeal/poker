package poker;

import java.util.*;

public class pokerHand {

    private Set<pokerCard> hand = new TreeSet<>();

    public pokerHand(){}
    private pokerHand(Set<pokerCard> hand){};
    private pokerHand(pokerCardsOrder number, pokerSuit suit){};

    Set<pokerCard> getHand() {
        return hand;
    }




}
