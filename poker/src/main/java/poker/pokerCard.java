package poker;

public class pokerCard {
    public pokerCardsOrder number;
    public pokerSuit suit;

    private pokerCard() {}

    public pokerCard(pokerCardsOrder number, pokerSuit suit){
        this.number = number;
        this.suit = suit;
    }

}
