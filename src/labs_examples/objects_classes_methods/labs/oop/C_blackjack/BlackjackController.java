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
        game.playerTurn();
        game.computerTurn();
        while(!isOver){
            isOver = !game.checkHands();
            game.playerTurn();
            game.computerTurn();
        }
    }

    public boolean checkHands(){
        if(playerHand.isOver21() || computerHand.isOver21()){
            return true;
        }else{
            return false;
        }
    }

    public void playerTurn(){
        while(!endTurn) {
            System.out.println(player.getName() + ", would you like to take another card?");
            System.out.println("Type \"y\" for yes or \"n\" for no and press \"Enter\": ");
            char userAnswer = input.next().charAt(0);
            if (userAnswer == 'y') {
                myDeck.dealCardTo(player);
                return;
            } else if (userAnswer == 'n') {
                System.out.println("You have chosen to stick.");
                endTurn = true;
                return;
            } else {
                System.out.println("Invalid input, please only type y or n.");
                continue;
            }
        }
    }

    public void computerTurn() {
        while (!compEndTurn) {
            System.out.println(computerAI.getName() + ", would you like to take another card?");
            if (computerAI.computerAIWantsCard()) {
                System.out.println("Computer has chosen to take another card.");
                myDeck.dealCardTo(computerAI);
                return;
            } else {
                System.out.println("Computer has chosen to stick.");
                compEndTurn = true;
                return;
            }
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

        playerHand.printHand(player);
        computerHand.printHand(computerAI);
        System.out.println(player.getName() + "'s score: " + playerHand.returnScoreOfHand());
        System.out.println(computerAI.getName() + "'s score: " + computerHand.returnScoreOfHand());



      /*  do{

            }
        }while((!(playerHand.isOver21())) | (!(computerHand.isOver21())) ); */

    }

}

