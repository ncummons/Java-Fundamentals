package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
     private Card[] cards = new Card[52];
     private ArrayList<Integer> usedCards = new ArrayList<>();
     Random random = new Random();


     public void emptyUsedCards(){
         this.usedCards.removeAll(usedCards);
     }

    public void dealCardTo(Player player){
        int randNum = random.nextInt(52);
        if(this.usedCards.contains(randNum)){
            while(this.usedCards.contains(randNum)){
                randNum = random.nextInt(52);
            }
        }
        this.usedCards.add(randNum);
        player.receiveCard(this.cards[randNum]);
        System.out.print(player.getName() + " has been dealt: ");
        cards[randNum].printCardName();
        return;
    }

    public Card[] createStandardDeck(){
        int cardCounter = 0;
        Card[] tempDeck = new Card[52];
        int suitCounter = 0;
        int valCounter = 1;
        for(int i = 0; i < 52; i++){

            Card tempCard = new Card();
            char[] suits = tempCard.getSuit();

            tempCard.setCardValue(valCounter);
            tempCard.setCardSuit(suits[suitCounter]);
            tempDeck[cardCounter] = tempCard;
            if(valCounter == 13){
                valCounter -= 12;
                suitCounter++;
            }else{
                valCounter++;
                }
            cardCounter++;
            }
        return tempDeck;
        }

        // Not sure how to set this up as a switch statement, but I figured this was better/more efficient
    public void setCardNames(){
        int cardValue;
        for(int i = 0; i < cards.length; i++){
            cardValue = cards[i].getCardValue();
                if(cardValue == 1){
                    cards[i].setCardName("Ace");
                }else if(cardValue > 1 && cardValue < 11){
                    cards[i].setCardName(String.valueOf(cardValue));
                }else if(cardValue == 11){
                    cards[i].setCardName("Jack");
                }else if(cardValue == 12){
                    cards[i].setCardName("Queen");
                }else if(cardValue == 13){
                    cards[i].setCardName("King");
                }
            }
        }



    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public ArrayList<Integer> getUsedCards() {
        return usedCards;
    }

    public void setUsedCards(ArrayList<Integer> usedCards) {
        this.usedCards = usedCards;
    }

    public Deck() {
    }


}
