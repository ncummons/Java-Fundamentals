package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

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
    // The pot will hold the "house's" values in the event of a tie and be added to winnings.
    Pot pot = new Pot(0);
    private static int gamesPlayed = 0;


    public static void main(String[] args) {
        BlackjackController game = new BlackjackController();


        boolean isOver = false;
        game.takeUserName();
        // begin loop here
        while(game.haveMoney()){
            game.printPlayerMoneyAndBet();
            game.playBlackJack();
            while(!isOver){
                game.playerTurn();
                game.computerTurn();
                isOver = game.checkHands();
                System.out.println("_____________________________________________________________________");
                System.out.println();
                System.out.println("_____________________________________________________________________");
            }
            isOver = false;
            game.winLoseSequence();
            System.out.println("_____________________________________________________________________");
            System.out.println();
            System.out.println("_____________________________________________________________________");
        }
        // end loop here
        // have system output the results of the betting and deal with a win/loss situation for that here too
        game.finalWinLose();
    }

    public void printPlayerMoneyAndBet(){
        System.out.println(player.getName() + " has $" + player.getPlayerMoney() + " to bet.");
        System.out.println(computerAI.getName() + " has $" + computerAI.getPlayerMoney() + " to bet.");
        System.out.println("Pot value: $" + pot.getPotValue());
        player.playerBets();
        computerAI.computerBets(player.getPlayerBet());
        pot.addBetsToPot(computerAI.getPlayerBet(), player.getPlayerBet());
        System.out.println("New Pot value: $" + pot.getPotValue());
    }

    public boolean haveMoney(){
        if(player.getPlayerMoney() <= 0 | computerAI.getPlayerMoney() <= 0){
            return false;
        }else{
            return true;
        }
    }

    public void finalWinLose(){
        if(player.getPlayerMoney() > computerAI.getPlayerMoney()){
            System.out.println("Computer is out of money.");
            System.out.println("Congratulations! " + player.getName() + ", you have won!");
        }else{
            System.out.println(player.getName() + " is out of money. :(");
            System.out.println("Sorry! " + player.getName() + ", you have lost! Computer wins.");
        }
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
            System.out.println("You both lost! Money stays in the pot.");
        }else if (playerHand.isOver21()){
            System.out.println("The computer has won! Computer receives the pot.");
            computerAI.setPlayerMoney(computerAI.getPlayerMoney()+pot.getPotValue());
            pot.setPotValue(0);
            computerAI.addWin();
        }else if (computerHand.isOver21()){
            System.out.println(player.getName() + " has won! Congratulations! You receive the pot.");
            player.setPlayerMoney(player.getPlayerMoney()+pot.getPotValue());
            pot.setPotValue(0);
            player.addWin();
        }else if(playerScore > computerScore){
            System.out.println(player.getName() + " has won! Congratulations! You receive the pot.");
            player.setPlayerMoney(player.getPlayerMoney()+pot.getPotValue());
            pot.setPotValue(0);
            player.addWin();
        }else if(playerScore < computerScore){
            System.out.println("The computer has won! Computer receives the pot.");
            computerAI.setPlayerMoney(computerAI.getPlayerMoney()+pot.getPotValue());
            pot.setPotValue(0);
            computerAI.addWin();
        }else{
            System.out.println("It's a tie! Money stays in the pot.");
        }
        System.out.println("Computer has won: " + computerAI.getNumGamesWon() + " games.");
        System.out.println(player.getName() + " has won: " + player.getNumGamesWon() + " games.");
        gamesPlayed++;
        System.out.println("Total number of games played: " + gamesPlayed);
        System.out.println("_____________________________________________________________________");
        System.out.println();
        System.out.println("_____________________________________________________________________");
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
            if((playerHand.returnScoreOfHand() > computerHand.returnScoreOfHand()) && compEndTurn) {
                System.out.println("You have automatically chosen to stick.");
                endTurn = true;
                return;
            }
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
            if((computerHand.returnScoreOfHand() > playerHand.returnScoreOfHand()) && endTurn){
                System.out.println("Computer has chosen to stick.");
                compEndTurn = true;
            }else if((computerHand.returnScoreOfHand() < playerHand.returnScoreOfHand()) && (playerHand.returnScoreOfHand() <= 21)){
                System.out.println("Computer has chosen to take another card.");
                myDeck.dealCardTo(computerAI);
            }else if (computerAI.computerAIWantsCard()){
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
    public void takeUserName(){
        System.out.print("Please type your name and press \"Enter\": ");
        player.setName(input.next());
        System.out.println();
        computerAI.setName("Computer Player");
        player.setPlayerMoney(100);
        computerAI.setPlayerMoney(100);
    }
    public void playBlackJack(){

        myDeck.setCards(myDeck.createStandardDeck());
        myDeck.setCardNames();
        playerHand.discardCards();
        computerHand.discardCards();
        playerHand.setHandValue(0);
        computerHand.setHandValue(0);
        myDeck.emptyUsedCards();
        endTurn = false;
        compEndTurn = false;


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

