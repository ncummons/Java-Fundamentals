package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Arrays;

public class Card {
    private static char[] suit = new char[] {'♠', '♦', '♥', '♣'};
    private int cardValue;
    private char cardSuit;
    private String cardName;

    public void printCardName(){
        System.out.println(cardName + " of " + cardSuit + "\'s");
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Card(int cardValue, char cardSuit) {
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }

    public Card() {
    }

    public char[] getSuit() {
        return suit;
    }


    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public char getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(char cardSuit) {
        this.cardSuit = cardSuit;
    }


}
