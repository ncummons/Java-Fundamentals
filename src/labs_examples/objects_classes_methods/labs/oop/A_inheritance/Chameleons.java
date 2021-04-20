package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Chameleons extends Reptiles{

    private int yearsOld;
    private String breed;
    private boolean hasHorns;
    private String name;

    public void blendIn(String environment){
        System.out.println("Your chameleon begins to blend in with the " + environment + "...");
        System.out.println("You've lost " + name + ".");
    }

    @Override
    public void eatAndGrow(double amount) {
        System.out.println("Your chameleon, " + name + " has now eaten: " + amount + " crickets and grown proportionally.");
        super.setLength(super.getLength()+(amount/30));
    }


    @Override
    public void makeSound() {
        System.out.println("Hoot... goes the Chameleon. (Yes, seriously. Hoot.)");
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

    public boolean isHasHorns() {
        return hasHorns;
    }

    public void setHasHorns(boolean hasHorns) {
        this.hasHorns = hasHorns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chameleons(int numLegs, double length, double speed, double tailLength, boolean laysEggs, String habitat) {
        super(numLegs, length, speed, tailLength, laysEggs, habitat);
    }

    public Chameleons(double tailLength, boolean laysEggs, String habitat) {
        super(tailLength, laysEggs, habitat);
    }

    public Chameleons(int numLegs, double length, double speed) {
        super(numLegs, length, speed);
    }

    public Chameleons() {
    }

    public Chameleons(int numLegs, double length, double speed, double tailLength, boolean laysEggs, String habitat, int yearsOld, String breed, boolean hasHorns, String name) {
        super(numLegs, length, speed, tailLength, laysEggs, habitat);
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.hasHorns = hasHorns;
        this.name = name;
    }

    public Chameleons(double tailLength, boolean laysEggs, String habitat, int yearsOld, String breed, boolean hasHorns, String name) {
        super(tailLength, laysEggs, habitat);
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.hasHorns = hasHorns;
        this.name = name;
    }

    public Chameleons(int numLegs, double length, double speed, int yearsOld, String breed, boolean hasHorns, String name) {
        super(numLegs, length, speed);
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.hasHorns = hasHorns;
        this.name = name;
    }

    public Chameleons(int yearsOld, String breed, boolean hasHorns, String name) {
        this.yearsOld = yearsOld;
        this.breed = breed;
        this.hasHorns = hasHorns;
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nChameleons{" +
                "\nyearsOld=" + yearsOld +
                ", \nbreed='" + breed + '\'' +
                ", \nhasHorns=" + hasHorns +
                ", \nname='" + name + '\'' +
                '}';
    }
}
