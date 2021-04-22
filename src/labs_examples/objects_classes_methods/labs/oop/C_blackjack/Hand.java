package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();
    private int handValue;

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
