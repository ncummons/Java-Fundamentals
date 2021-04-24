package labs_examples.objects_classes_methods.labs.oop.C_blackjack;
import com.sun.tools.classfile.ConstantPool;

import java.util.Scanner;

public class BlackjackController {

    Scanner input = new Scanner(System.in);
    Player player = new Player();
    Player computerAI = new Player();
    Deck myDeck = new Deck();
    Hand playerHand = new Hand();
    Hand computerHand = new Hand();
    private boolean endTurn = false;
    private boolean compEndTurn = false;

    public static void main(String[] args) {
        BlackjackController game = new BlackjackController();
        boolean isOver = false;
        game.playBlackJack();
        while(!isOver){
            game.playerTurn();
            game.computerTurn();
            isOver = game.checkHands();
        }
        game.winLoseSequence();
    }

    public void winLoseSequence(){
        int playerScore = playerHand.returnScoreOfHand();
        int computerScore = computerHand.returnScoreOfHand();
        System.out.print("Game results: ");
        playerHand.printHand(player);
        System.out.println(player.getName() + "'s score: " + playerHand.returnScoreOfHand());
        computerHand.printHand(computerAI);
        System.out.println(computerAI.getName() + "'s score: " + computerHand.returnScoreOfHand());
        if(playerHand.isOver21() & computerHand.isOver21()){
            System.out.println("You both lost! House takes the pot.");
        }else if (playerHand.isOver21()){
            System.out.println("The computer has won! Computer receives the pot.");
        }else if (computerHand.isOver21()){
            System.out.println(player.getName() + " has won! Congratulations! You receive the pot.");
        }else if(playerScore > computerScore){
            System.out.println(player.getName() + " has won! Congratulations! You receive the pot.");
        }else if(playerScore < computerScore){
            System.out.println("The computer has won! Computer receives the pot.");
        }else{
            System.out.println("It's a tie! Money stays in the pot.");
        }
    }

    public boolean checkHands(){
        if(playerHand.isOver21() || computerHand.isOver21()){
            if(playerHand.isOver21()){
                System.out.println(player.getName() + " is bust!");
            }
            if(computerHand.isOver21()){
                System.out.println(computerAI.getName() + " is bust!");
            }
            return true;
        }else if(endTurn && compEndTurn){
            return true;
        }
        else{
            return false;
        }
    }

    public void playerTurn(){
        while(!endTurn) {
            playerHand.printHand(player);
            System.out.println(player.getName() + "'s score: " + playerHand.returnScoreOfHand());
            System.out.println(player.getName() + ", would you like to take another card?");
            System.out.println("Type \"y\" for yes or \"n\" for no and press \"Enter\": ");
            char userAnswer = input.next().charAt(0);
            if (userAnswer == 'y') {
                myDeck.dealCardTo(player);
                System.out.println(player.getName() + "'s score: " + playerHand.returnScoreOfHand());
                playerHand.setHandValue(playerHand.returnScoreOfHand());
                if(playerHand.returnScoreOfHand() > 21){
                    System.out.println("Bust!");
                }
                return;
            } else if (userAnswer == 'n') {
                System.out.println("You have chosen to stick.");
                endTurn = true;
                System.out.println(player.getName() + "'s score: " + playerHand.returnScoreOfHand());
                playerHand.setHandValue(playerHand.returnScoreOfHand());
                return;
            } else {
                System.out.println("Invalid input, please only type y or n.");
                continue;
            }
        }
    }

    public void computerTurn() {
        while (!compEndTurn) {
            computerHand.printHand(computerAI);
            System.out.println(computerAI.getName() + "'s score: " + computerHand.returnScoreOfHand());
            System.out.println(computerAI.getName() + ", would you like to take another card?");
            if (computerAI.computerAIWantsCard()) {
                System.out.println("Computer has chosen to take another card.");
                myDeck.dealCardTo(computerAI);
            } else {
                System.out.println("Computer has chosen to stick.");
                compEndTurn = true;
            }
            System.out.println(computerAI.getName() + "'s score: " + computerHand.returnScoreOfHand());
            computerHand.setHandValue(computerHand.returnScoreOfHand());
            if(computerHand.returnScoreOfHand() > 21){
                System.out.println("Bust!");
            }
            return;
        }
    }

    public void playBlackJack(){

        System.out.print("Please type your name and press \"Enter\": ");
        player.setName(input.next());
        System.out.println();
        computerAI.setName("Computer Player");


        myDeck.setCards(myDeck.createStandardDeck());
        myDeck.setCardNames();


        player.setHand(playerHand);
        computerAI.setHand(computerHand);

        myDeck.dealCardTo(player);
        myDeck.dealCardTo(player);
        myDeck.dealCardTo(computerAI);
        myDeck.dealCardTo(computerAI);

        playerHand.setHandValue(playerHand.returnScoreOfHand());
        computerHand.setHandValue(computerHand.returnScoreOfHand());

        System.out.println(player.getName() + "'s score: " + playerHand.returnScoreOfHand());
        System.out.println(computerAI.getName() + "'s score: " + computerHand.returnScoreOfHand());

    }

}

