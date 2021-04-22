package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
     private Card[] cards = new Card[52];
     private ArrayList<Integer> usedCards = new ArrayList<>();
     Random random = new Random();


    public void dealCardTo(Player player){
        int randNum = random.nextInt(52);
        if(this.usedCards.contains(randNum)){
            while(this.usedCards.contains(randNum)){
                randNum = random.nextInt(52);
            }
        }
        this.usedCards.add(randNum);
        player.receiveCard(this.cards[randNum]);
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
