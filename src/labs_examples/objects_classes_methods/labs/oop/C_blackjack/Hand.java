package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();
    private int handValue;

    // Returns an integer value that represents the score of the player's hand (need to assign to a variable or use)
    // added feature where ace can be 1 or 11
    public int returnScoreOfHand(){
        int score = 0;
        int cardVal;
        Card currentCard;
        for(int i = 0; i < cards.size(); i++) {
            currentCard = cards.get(i);
            cardVal = currentCard.getCardValue();
            if (cardVal > 10) {
                score += 10;
            } else if(cardVal == 1){
                score += 11;
            } else {
                score += cardVal;
            }
        }
        for(int i = 0; i < cards.size(); i++) {
            currentCard = cards.get(i);
            cardVal = currentCard.getCardValue();
            if ((cardVal == 1 && score - 10 == 21) || (cardVal == 1 && score > 21)) {
                    score-=10;
            }else{
                break;
            }
        }
        return score;
    }

    public void discardCards(){
        this.cards.removeAll(cards);
    }

    // if the player is over 21 hand value, this will return true and the player is bust
    public boolean isOver21(){
        if(this.handValue > 21){
            return true;
        }else{
            return false;
            }
    }

    public void printHand(Player owner){
        System.out.println(owner.getName() + "'s hand contains:");
        for(int i = 0; i < cards.size(); i++){
            cards.get(i).printCardName();
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
