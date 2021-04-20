package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Animals {

    private int NumLegs;
    private double length;
    private double speed;

    public void makeSound(){
        System.out.println("Grrr... Says the animal.");
    }

    public void eatAndGrow(double amount){
        System.out.println("Your animal has now eaten: " + amount + " units of food and grown proportionally.");
        setLength(this.length+(amount/10));
    }

    public int getNumLegs() {
        return NumLegs;
    }

    public void setNumLegs(int numLegs) {
        NumLegs = numLegs;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "NumLegs=" + NumLegs +
                ", length=" + length +
                ", speed=" + speed +
                '}';
    }

    public Animals(int numLegs, double length, double speed) {
        NumLegs = numLegs;
        this.length = length;
        this.speed = speed;
    }

    public Animals() {
    }
}
