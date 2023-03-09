package poker;

import java.util.*;

public class pokerHand {
    private final int MAX_NUM_CARDS = 5;
    private final int LOWER_RANGE = 4;

    private ArrayList<pokerCard> hand = new ArrayList<pokerCard>();
    private  HashMap<pokerSuit, Integer> handBySuite = new HashMap<pokerSuit, Integer>();
    private pokerHandResult  handRank = new pokerHandResult();
    private  TreeMap<pokerCardsOrder, Integer> pokerVals =
            new TreeMap<pokerCardsOrder, Integer>(Comparator.reverseOrder());

    private String playerName;

    public String getPlayerName(){
        return this.playerName;
    }

    public pokerHand(String playerName){
        this.playerName = playerName;
    }

    private pokerHand(){};
    private pokerHand(Set<pokerCard> hand){};
    private pokerHand(pokerCardsOrder number, pokerSuit suit){};

    public void addCardToHand(pokerCard card){
        hand.add(card);
        Collections.sort(hand);
        if(!handBySuite.containsKey(card.suit)){
            handBySuite.put(card.suit,1);
        } else {
            Integer count = handBySuite.get(card.suit);
            handBySuite.put(card.suit,++count);
        }
        if(!pokerVals.containsKey(card.number))
        {
            pokerVals.put(card.number,1);
        } else{
            Integer count = pokerVals.get(card.number);
            pokerVals.put(card.number,++count);
        }
    }

    public ArrayList<pokerCard> getHand() {
        return hand;
    }

    public boolean isCardHandFull(){
        return (hand.size() == MAX_NUM_CARDS);
    }

    public pokerCard getCard(int cardIndex){
        pokerCard returnedCard = null;
        if(cardIndex>=0 && cardIndex<=MAX_NUM_CARDS){
            ArrayList<pokerCard> temp = new ArrayList<pokerCard>(hand);
            Collections.reverse(temp);
            returnedCard = temp.stream().toList().get(cardIndex) ;
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
        this.handRank.playerName = this.playerName;
        int numberOfSuitsInHand = this.getNumberOfSuitsInHand();
        boolean handHasBeenSet= false;
        switch (numberOfSuitsInHand){
            case 1: handHasBeenSet = processOneSuite();
                break;
            case 2: handHasBeenSet = processTwoSuites();
                break;
            case 3: handHasBeenSet = processThreeSuites();
                break;
            case 4: handHasBeenSet = processFourSuites();
            default:
                break;
        }
        if(!handHasBeenSet){
            checkIsHandStraight();
        }

    }


    public pokerHandResult getHandResult(){
        return this.handRank;
    }

    private boolean checkContinuousCards(){
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

    private boolean processOneSuite() {
        boolean handHasBeenSet= false;
        if(this.checkContinuousCards()){
            handRank.handName = pokerHands.STRAIGHT_FLUSH;
            handHasBeenSet = true;
        } else{
            handRank.handName = pokerHands.FLUSH;
            handHasBeenSet = true;
        }
        handRank.firstHighVal = this.getCard(0).number;
        this.sortHandResults();
        return handHasBeenSet;
    }

    private boolean processTwoSuites() {
        boolean handHasBeenSet= false;
        int numPairs = 0;

        Set<pokerCardsOrder> keySet = pokerVals.descendingKeySet();

        List<pokerCardsOrder> temp = new ArrayList<pokerCardsOrder>(keySet.stream().toList());
        Collections.reverse(temp);

        for (pokerCardsOrder key : temp) {
            int numVals = pokerVals.get(key);
            if(numVals == 2) {
                if (numPairs == 0) {
                    handRank.handName = pokerHands.PAIR;
                    handRank.firstHighVal = key;
                    numPairs++;
                    handHasBeenSet = true;
                } else if (numPairs == 1) {
                    handRank.handName = pokerHands.TWO_PAIRS;
                    handRank.secondHighVal = key;
                    handHasBeenSet = true;
                } else {
                    //
                }
            }
        }
        this.sortHandResults();
        return handHasBeenSet;
    }

    private boolean processThreeSuites() {
        boolean handHasBeenSet= false;

        if(pokerVals.size()==2){
            handRank.handName = pokerHands.FULL_HOUSE;
            Set<pokerCardsOrder> keySet = pokerVals.descendingKeySet();
            List<pokerCardsOrder> temp = new ArrayList<pokerCardsOrder>(keySet.stream().toList());
            Collections.reverse(temp);
            for (pokerCardsOrder key : temp) {
                int numVals = pokerVals.get(key);
                if(numVals == 3){
                    handRank.firstHighVal = key;
                } else {
                    handRank.secondHighVal = key;
                }
            }
            handHasBeenSet = true;

        } else {
            Set<pokerCardsOrder> keySet = pokerVals.descendingKeySet();
            List<pokerCardsOrder> temp = new ArrayList<pokerCardsOrder>(keySet.stream().toList());
            Collections.reverse(temp);
            for (pokerCardsOrder key : temp) {
                int numVals = pokerVals.get(key);
                if (numVals == 3) {
                    handRank.handName = pokerHands.THREE_OF_A_KIND;
                    handRank.firstHighVal = key;
                    handHasBeenSet = true;
                }
            }
        }
        this.sortHandResults();
        return handHasBeenSet;
    }

    private boolean processFourSuites() {
        boolean handHasBeenSet= false;

        if(pokerVals.size()==2){
            Set<pokerCardsOrder> keySet = pokerVals.descendingKeySet();
            List<pokerCardsOrder> temp = new ArrayList<pokerCardsOrder>(keySet.stream().toList());
            Collections.reverse(temp);
            handRank.firstHighVal = pokerCardsOrder.T2;
            for (pokerCardsOrder key : temp) {
                int numVals = pokerVals.get(key);

                if(numVals == 4){
                    handRank.firstHighVal = key;
                    handRank.handName = pokerHands.FOUR_OF_A_KIND;
                } else if ((numVals == 3) || (numVals == 2)){
                    pokerCardsOrder tempKey = key;
                    if(tempKey.ordinal() > handRank.firstHighVal.ordinal()){
                        handRank.firstHighVal = tempKey;
                    }
                    handRank.handName = pokerHands.FULL_HOUSE;
                }
            }
            handHasBeenSet = true;
        }
        this.sortHandResults();
        return handHasBeenSet;
    }

    private void sortHandResults(){
        for(int r = 1; r < MAX_NUM_CARDS;r++){
            pokerCardsOrder order = hand.stream().toList().get(r).number;
            handRank.remainingValue[r-1] = order;
        }
    }

    private void checkIsHandStraight() {
        if(checkContinuousCards()){
            handRank.handName = pokerHands.STRAIGHT;
        } else {
            handRank.handName = pokerHands.HIGH_CARD;
        }
        handRank.firstHighVal = this.getCard(0).number;
        handRank.secondHighVal = this.getCard(1).number;
    }


}

