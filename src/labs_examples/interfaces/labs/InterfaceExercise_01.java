package labs_examples.interfaces.labs;

/**
 * Interfaces Exercise 1:
 *
 *      1) Write an interface with at least three methods. Write two classes that implement the
 *          interface in different ways.
 *      2) Write a class that extends one of the classes from the previous step. Override the methods in
 *          the parent class.
 *
 *      NOTE: We encourage you to be creative and try to think of an example of your own for this
 *       exercise but if you are stuck, some ideas include:
 *
 *       - A Vehicle interface, that is advanced by a Tractor class and a Scooter class. Two of the methods could be
 *          turnOn() and brake().
 *       - A PersonalDevice interface that is implemented by an iPad class and a Computer class. Two of the methods could be
 *          playMusic() and turnOff().
 *
 *          I will use a enemy player interface with the classes: archer and foot soldier
 *
 */


class GameController {
    public static void main(String[] args) {
        FootSoldier mySoldier = new FootSoldier();
        Archer myArcher = new Archer();

        myArcher.attack();
        myArcher.dealDamage();
        myArcher.dropLoot();

        mySoldier.attack();
        mySoldier.dealDamage();
        mySoldier.dropLoot();

    }
}

interface EnemyPlayer {

    public void attack();
    public void dealDamage();
    public void dropLoot();

}

class Archer implements EnemyPlayer{
    public void attack(){
        System.out.println("The archer shoots his bow at you!");
    }
    public void dealDamage(){
        System.out.println("The archer has hit you with an arrow, causing 10 damage.");
    }
    public void dropLoot(){
        System.out.println("The archer has dropped a yew bow and 10 coins.");
    }
}

class FootSoldier implements EnemyPlayer{
    public void attack(){
        System.out.println("The foot soldier swings his sword at you!");
    }
    public void dealDamage(){
        System.out.println("The foot soldier has hit you with his sword, causing 15 damage.");
    }
    public void dropLoot(){
        System.out.println("The foot soldier has dropped a steel sword and 5 coins.");
    }
}