package labs_examples.objects_classes_methods.labs.oop.C_blackjack;
import java.util.Scanner;

public class Player {
    protected int numGamesWon = 0;
    protected String name;
    protected Hand hand;
    protected int playerMoney;
    protected int playerBet;
    protected Scanner betInput = new Scanner(System.in);

    public void playerBets(){
        System.out.println("How much would you like to bet? You have $" + getPlayerMoney() + ".");
        int betAmount = betInput.nextInt();
        while(betAmount <= 0 && betAmount > playerMoney){
            System.out.println("You can only bet from $1 up to the amount that you have. Please try again.");
            System.out.println("Please bet again: ");
            betAmount = betInput.nextInt();
        }
            // Proceed to bet
        this.playerMoney -= betAmount;
        this.playerBet = betAmount;
        }

        public void computerBets(int otherPlayerBet){
        if (otherPlayerBet < this.playerMoney) {
            System.out.println(this.name + " matches your bet of $" + otherPlayerBet);
            this.playerMoney -= otherPlayerBet;
            this.playerBet = otherPlayerBet;
            }else{
            System.out.println(this.name + " goes all in with $" + this.playerMoney + ".");
            this.playerBet = this.playerMoney;
            this.playerMoney = 0;
        }
        }


    public boolean computerAIWantsCard(){
        int scoreHand = this.hand.returnScoreOfHand();
        if(scoreHand < 16){
            return true;
        }else{
            return false;
        }
    }

    public void receiveCard(Card addingCard){
        this.hand.addCard(addingCard);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public int getPlayerBet() {
        return playerBet;
    }

    public void setPlayerBet(int playerBet) {
        this.playerBet = playerBet;
    }

    public void addWin(){
        this.numGamesWon++;
    }

    public int getNumGamesWon() {
        return numGamesWon;
    }

    public void setNumGamesWon(int numGamesWon) {
        this.numGamesWon = numGamesWon;
    }
}
