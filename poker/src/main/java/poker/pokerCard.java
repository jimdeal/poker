package poker;

public class pokerCard implements Comparable<pokerCard>{
    public pokerCardsOrder number;
    public pokerSuit suit;

    private pokerCard() {}

    public pokerCard(pokerCardsOrder number, pokerSuit suit){
        this.number = number;
        this.suit = suit;
    }

    @Override
    public int compareTo(poker.pokerCard o) {
        return number.compareTo(o.number);
    }


}
