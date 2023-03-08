package poker;

public class pokerTwoPlayerGame {

    public pokerHandResult scoreGame(pokerHand hand1, pokerHand hand2){
        pokerHandResult winner = new pokerHandResult();
        hand1.processHand();
        hand2.processHand();

        pokerHandResult hand1Result = hand1.getHandResult();
        pokerHandResult hand2Result = hand2.getHandResult();

        if(hand1Result.handName.ordinal() > hand2Result.handName.ordinal()){
            winner = hand1Result;
        } else if(hand1Result.handName.ordinal() < hand2Result.handName.ordinal()){
            winner = hand2Result;
        } else{
            winner = processFirstTiedHand(hand1,  hand2);
        }
        return winner;
    }

    private pokerHandResult processFirstTiedHand(pokerHand hand1, pokerHand hand2){
        pokerHandResult winner = new pokerHandResult();
        if(hand1.getHandResult().firstHighVal.ordinal() > hand2.getHandResult().firstHighVal.ordinal()){
            winner = hand1.getHandResult();
        } else if (hand1.getHandResult().firstHighVal.ordinal() < hand2.getHandResult().firstHighVal.ordinal()){
            winner = hand2.getHandResult();
        }else{
            winner = processSecondTiedHand(hand1,  hand2);
        }
        return winner;
    }

    private pokerHandResult processSecondTiedHand(pokerHand hand1, pokerHand hand2){
        pokerHandResult winner = new pokerHandResult();
        if(hand1.getHandResult().secondHighVal.ordinal() > hand2.getHandResult().secondHighVal.ordinal()){
            winner = hand1.getHandResult();
        } else if (hand1.getHandResult().secondHighVal.ordinal() < hand2.getHandResult().secondHighVal.ordinal()){
            winner = hand2.getHandResult();
        }else{
            winner = processRemain(hand1,  hand2);
        }
        return winner;
    }

    private pokerHandResult processRemain(pokerHand hand1, pokerHand hand2){
        pokerHandResult winner = new pokerHandResult();
        if(hand1.getHandResult().remainingValue[0].ordinal() > hand2.getHandResult().remainingValue[0].ordinal()){
            winner = hand1.getHandResult();
        } else if (hand1.getHandResult().remainingValue[0].ordinal() < hand2.getHandResult().remainingValue[0].ordinal()){
            winner = hand2.getHandResult();
        }else{

        }
        return winner;
    }

}
