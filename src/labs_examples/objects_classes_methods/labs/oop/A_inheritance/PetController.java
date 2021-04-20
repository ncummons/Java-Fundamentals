package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class PetController {

    public static void main(String[] args) {

    Animals mammal = new Animals(4, 12, 8);

    System.out.println("I have a mammal with the following traits: \n" + mammal.toString());
    mammal.eatAndGrow(10);
    System.out.println("The mammal is now " + mammal.getLength() + " feet long.");
    mammal.makeSound();

    Reptiles genericLizard = new Reptiles(4, .75, 14, .42, true, "Tropical");

    System.out.println("I now have a nice little lizard that lives in a " + genericLizard.getHabitat() + " habitat.");
    System.out.println("It has the following traits: \n" + genericLizard.toString());
    genericLizard.eatAndGrow(2);
    System.out.println("Now the lizard is: " + genericLizard.getLength() + " feet long.");
    genericLizard.makeSound();

    Chameleons myChameleon = new Chameleons(4, .85, 4, .38, true, "Tropical", 3, "Panther", false, "T'Chala");

    System.out.println("I am super stoked that I just got " + myChameleon.getName() + "! He's a " + myChameleon.getBreed() + " Chameleon.");
    System.out.println("He has the following traits: " + myChameleon.toString());
    myChameleon.eatAndGrow(8);
    System.out.println("Now " + myChameleon.getName() + " is " + myChameleon.getLength() + " feet long.");
    myChameleon.makeSound();
    myChameleon.blendIn("mother-in-law's hair");

    Geckos myGecko = new Geckos(3, .45, 15, .21, true, "Tropical", 4, "Crested", true, "Spot");

    System.out.println("I have a pet " + myGecko.getBreed() + " gecko named " + myGecko.getName() + " and he only has " + myGecko.getNumLegs() + " legs.");
    System.out.println("He has the following traits: " + myGecko.toString());
    myGecko.eatAndGrow(14);
    System.out.println("Now " + myGecko.getName() + " is " + myGecko.getLength() + " feet long.");
    myGecko.makeSound();
    myGecko.runAway(15);

    Snakes mySnake = new Snakes(0, 3, 11, 2.9, true, "Estuaries", 2, "Coral", true, "Pax");
    System.out.println("I have a pet " + mySnake.getBreed() + " snake named " + mySnake.getName() + " and he doesn't have legs.");
    System.out.println("He has the following traits: " + mySnake.toString());
    mySnake.eatAndGrow(6);
    System.out.println("Now " + mySnake.getName() + " is " + mySnake.getLength() + " feet long.");
    mySnake.makeSound();
    mySnake.biteOwner();
    System.out.println("It's time to get a new snake...");
    mySnake.setBreed("Corn");
    mySnake.setVenomous(false);
    mySnake.setName("Bellum");
    System.out.println("You go to the store and purchase a new snake.");
    mySnake.biteOwner();

    }

}
