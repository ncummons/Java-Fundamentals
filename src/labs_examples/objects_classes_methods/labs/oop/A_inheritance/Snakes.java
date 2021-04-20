package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Snakes extends Reptiles {

    private int yearsOld;
    private String breed;
    private boolean isVenomous;
    private String name;

    public void biteOwner(){
        System.out.println("Your snake lunges at you and bites you.");
            if(this.isVenomous == true){
                System.out.println("Oh no! " + name + " is venomous!");
                System.out.println("The venom begins to burn through your veins. Seek immediate medical attention!");
        }else{
            System.out.println("You smack " + name + ".");
            System.out.println("Good thing your snake isn't venomous!");
            }
    }

    @Override
    public void eatAndGrow(double amount) {
        System.out.println("Your snake, " + name + " has now eaten: " + amount + " mice and grown proportionally.");
        super.setLength(super.getLength()+(amount/15));
    }


    @Override
    public void makeSound() {
        System.out.println("Hisssss... goes the snake.");
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isVenomous() {
        return isVenomous;
    }

    public void setVenomous(boolean venomous) {
        isVenomous = venomous;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSnakes{" +
                "\nyearsOld=" + yearsOld +
                ", \nbreed='" + breed + '\'' +
                ", \nisVenomous=" + isVenomous +
                ", \nname='" + name + '\'' +
                '}';
    }

    public Snakes(int numLegs, double length, double speed, double tailLength, boolean laysEggs, String habitat, int yearsOld, String breed, boolean isVenomous, String name) {
        super(numLegs, length, speed, tailLength, laysEggs, habitat);
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.isVenomous = isVenomous;
        this.name = name;
    }

    public Snakes(double tailLength, boolean laysEggs, String habitat, int yearsOld, String breed, boolean isVenomous, String name) {
        super(tailLength, laysEggs, habitat);
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.isVenomous = isVenomous;
        this.name = name;
    }

    public Snakes(int numLegs, double length, double speed, int yearsOld, String breed, boolean isVenomous, String name) {
        super(numLegs, length, speed);
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.isVenomous = isVenomous;
        this.name = name;
    }

    public Snakes(int yearsOld, String breed, boolean isVenomous, String name) {
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.isVenomous = isVenomous;
        this.name = name;
    }

    public Snakes(int numLegs, double length, double speed, double tailLength, boolean laysEggs, String habitat) {
        super(numLegs, length, speed, tailLength, laysEggs, habitat);
    }

    public Snakes(double tailLength, boolean laysEggs, String habitat) {
        super(tailLength, laysEggs, habitat);
    }

    public Snakes(int numLegs, double length, double speed) {
        super(numLegs, length, speed);
    }

    public Snakes() {
    }
}
