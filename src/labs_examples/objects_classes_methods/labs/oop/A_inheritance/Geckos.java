package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Geckos extends Reptiles {

    private int yearsOld;
    private String breed;
    private boolean hasToePads;
    private String name;

    public void runAway(int distance){
        System.out.println("Your gecko jumps away and runs " + distance + " feet away, super fast.");
        System.out.println("You're unable to catch your gecko again. It keeps running and is too fast.");
        System.out.println("Sorry. You've lost " + name + ".");
    }

    @Override
    public void eatAndGrow(double amount) {
        System.out.println("Your gecko, " + name + " has now eaten: " + amount + " crickets and grown proportionally.");
        super.setLength(super.getLength()+(amount/50));
    }


    @Override
    public void makeSound() {
        System.out.println("Gecko... goes the gecko. How fitting.");
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

    public boolean isHasToePads() {
        return hasToePads;
    }

    public void setHasToePads(boolean hasToePads) {
        this.hasToePads = hasToePads;
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
                "\nGeckos{" +
                "\nyearsOld=" + yearsOld +
                ", \nbreed='" + breed + '\'' +
                ", \nhasToePads=" + hasToePads +
                ", \nname='" + name + '\'' +
                '}';
    }

    public Geckos(int numLegs, double length, double speed, double tailLength, boolean laysEggs, String habitat, int yearsOld, String breed, boolean hasToePads, String name) {
        super(numLegs, length, speed, tailLength, laysEggs, habitat);
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.hasToePads = hasToePads;
        this.name = name;
    }

    public Geckos(double tailLength, boolean laysEggs, String habitat, int yearsOld, String breed, boolean hasToePads, String name) {
        super(tailLength, laysEggs, habitat);
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.hasToePads = hasToePads;
        this.name = name;
    }

    public Geckos(int numLegs, double length, double speed, int yearsOld, String breed, boolean hasToePads, String name) {
        super(numLegs, length, speed);
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.hasToePads = hasToePads;
        this.name = name;
    }

    public Geckos(int yearsOld, String breed, boolean hasToePads, String name) {
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.hasToePads = hasToePads;
        this.name = name;
    }

    public Geckos(int numLegs, double length, double speed, double tailLength, boolean laysEggs, String habitat) {
        super(numLegs, length, speed, tailLength, laysEggs, habitat);
    }

    public Geckos(double tailLength, boolean laysEggs, String habitat) {
        super(tailLength, laysEggs, habitat);
    }

    public Geckos(int numLegs, double length, double speed) {
        super(numLegs, length, speed);
    }

    public Geckos() {
    }
}
