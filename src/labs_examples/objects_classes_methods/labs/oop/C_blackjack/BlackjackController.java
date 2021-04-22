package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class BlackjackController {
    public static void main(String[] args) {
        Deck myDeck = new Deck();
        myDeck.setCards(myDeck.createStandardDeck());
        Hand myHand = new Hand();
        Player myPlayer = new Player();
        myPlayer.setHand(myHand);
        Player yourPlayer = new Player();
        Hand yourHand = new Hand();
        yourPlayer.setHand(yourHand);

        myDeck.dealCardTo(myPlayer);
        myDeck.dealCardTo(yourPlayer);

        // So far, the deck works for both players as it should and each player can have a separate hand of cards.


    }

}

