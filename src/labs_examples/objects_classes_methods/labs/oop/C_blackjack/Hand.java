package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();
    private int handValue;

    // Returns an integer value that represents the score of the player's hand (need to assign to a variable or use)
    public int returnScoreOfHand(){
        int score = 0;
        int cardVal;
        Card currentCard;
        for(int i = 0; i < cards.size(); i++){
            currentCard = cards.get(i);
            cardVal = currentCard.getCardValue();
            if(cardVal > 10){
                score+= 10;
            }else{
                score += cardVal;
            }
        }
        return score;
    }

    // if the player is over 21 hand value, this will return true and the player is bust
    public boolean isOver21(){
        if(this.handValue > 21){
            return true;
        }else{
            return false;
            }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card newCard) {
         this.cards.add(newCard);
    }

    public int getHandValue() {
        return handValue;
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }
}
