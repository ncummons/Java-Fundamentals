package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class Exercise_01 {
    public static void main(String[] args) {

        // Begin working through exercise part 1 here with Overloading. I have overloaded level up to take in an int
        // as well as a double value. (The constructors have also been overloaded as fully qualified and empty)
        PlayerCharacter myCharacter = new PlayerCharacter();
        myCharacter.setLevel(1);
        myCharacter.setName("Link");
        PlayerCharacter yourCharacter = new PlayerCharacter("Zelda", 10);

        myCharacter.levelUp(15);
        yourCharacter.levelUp(1.4);

        System.out.println("My character is level " + myCharacter.getLevel());
        System.out.println("And your character is level " + yourCharacter.getLevel());

        // Overriding -- I have overridden the levelUp method and declareName method in both of the subclasses
        // of PlayerCharacter, Knight and Ranger, to show their respective differences

        Knight yourKnight = new Knight("Aragon", 30, "Isildor's Blade", 98 );
        Ranger myRanger = new Ranger("Legolas", 35, "Mirkwood Bow", 104);

        yourKnight.declareName();
        myRanger.declareName();
        yourKnight.levelUp(8);
        myRanger.levelUp(5);

        // I have used an interface for MovementControls to ensure that all players have movement controls, no matter which
        // game they are playing and in this case, there are no beds... so no sleeping.
        // I implemented the interface in the PlayerCharacter class and the two subclasses inherit the methods of movement,
        // as would any subsequent or other subclasses

        myRanger.playerWalking(20,3);
        myRanger.playerRunning(10,12);
        yourKnight.playerRunning(20,8);
        yourKnight.playerWalking(10,4);
        myRanger.playerResting();
        yourKnight.playerSleeping();

    }
}

interface MovementControls{
    public void playerWalking(int distance, int speed);
    public void playerRunning(int distance, int speed);
    public void playerResting();
    public default void playerSleeping(){
        System.out.println("There are no beds in this game.");
    }
}

class PlayerCharacter implements MovementControls{

    private String name;
    private int level;

    public void levelUp(int x){
        System.out.println("Congratulations you have leveled up by " + x + " levels!");
        this.level += x;
        System.out.println("You are now level: " + this.level);
    }

    public void levelUp(double d){
        System.out.println("Congratulations you have leveled up by " + d + " levels!");
        this.level += (int)d;
        System.out.println("You are now level: " + this.level);
    }

    public void declareName(){
        System.out.println("Hello, my name is " + this.name + " and I am level " + this.level);
    }

    public PlayerCharacter() {
    }

    public PlayerCharacter(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void playerWalking(int distance, int speed) {
        System.out.println("Your character, " + this.name +  ", is walking " + distance + " miles at " + speed + " mph.");
    }

    @Override
    public void playerRunning(int distance, int speed) {
        System.out.println("Your character, " + this.name +  ",  is running " + distance + " miles at " + speed + " mph.");
    }

    @Override
    public void playerResting() {
        System.out.println("Your character, " + this.name +  ",  is now at rest.");
    }
}

class Knight extends PlayerCharacter{

    private String sword;
    private int strength;

    @Override
    public void levelUp(int x) {
        System.out.println("Congratulations you have leveled up by " + x + " levels!");
        super.setLevel(super.getLevel() + x);
        this.strength += x;
        System.out.println("You are now level: " + super.getLevel() + " with a strength of " + this.strength);
    }

    @Override
    public void declareName(){
        System.out.println("Hello, my name is " + super.getName() + " and I have a(n) " + this.sword + ".");
    }


    public Knight() {
    }

    public Knight(String sword, int strength) {
        this.sword = sword;
        this.strength = strength;
    }

    public Knight(String name, int level, String sword, int strength) {
        super(name, level);
        this.sword = sword;
        this.strength = strength;
    }

    public String getSword() {
        return sword;
    }

    public void setSword(String sword) {
        this.sword = sword;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}

class Ranger extends PlayerCharacter{

    private String bow;
    private int agility;

    @Override
    public void declareName(){
        System.out.println("Hello, my name is " + super.getName() + " and I have a(n) " + this.bow + ".");
    }

    @Override
    public void levelUp(int x) {
        System.out.println("Congratulations you have leveled up by " + x + " levels!");
        super.setLevel(super.getLevel() + x);
        this.agility += x;
        System.out.println("You are now level: " + super.getLevel() + " with an agility of " + this.agility);
    }

    public Ranger() {
    }

    public Ranger(String bow, int agility) {
        this.bow = bow;
        this.agility = agility;
    }

    public Ranger(String name, int level, String bow, int agility) {
        super(name, level);
        this.bow = bow;
        this.agility = agility;
    }

    public String getBow() {
        return bow;
    }

    public void setBow(String bow) {
        this.bow = bow;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
}