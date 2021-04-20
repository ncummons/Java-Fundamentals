package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Reptiles extends Animals {

    private double tailLength;
    private boolean laysEggs;
    private String habitat;

    @Override
    public void eatAndGrow(double amount) {
        System.out.println("Your reptile has now eaten: " + amount + " little animals and grown proportionally.");
        super.setLength(super.getLength()+(amount/20));
    }

    @Override
    public void makeSound() {
        System.out.println("Slither... goes the reptile.");
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public boolean isLaysEggs() {
        return laysEggs;
    }

    public void setLaysEggs(boolean laysEggs) {
        this.laysEggs = laysEggs;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nReptiles{" +
                "\ntailLength=" + tailLength +
                ", \nlaysEggs=" + laysEggs +
                ", \nhabitat='" + habitat + '\'' +
                '}';
    }

    public Reptiles(int numLegs, double length, double speed, double tailLength, boolean laysEggs, String habitat) {
        super(numLegs, length, speed);
        this.tailLength = tailLength;
        this.laysEggs = laysEggs;
        this.habitat = habitat;
    }

    public Reptiles(double tailLength, boolean laysEggs, String habitat) {
        this.tailLength = tailLength;
        this.laysEggs = laysEggs;
        this.habitat = habitat;
    }

    public Reptiles(int numLegs, double length, double speed) {
        super(numLegs, length, speed);
    }

    public Reptiles() {
    }
}
