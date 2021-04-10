package labs_examples.objects_classes_methods.labs.objects;

public class Exercises2To4 {

    public static void main(String[] args) {

        // Ex. 2 - these two objects are associated together in the same print output,
        // but they are not dependent on each other
        UnrelatedGame halo = new UnrelatedGame("Halo");
        NewGame runescape = new NewGame("Runescape");
        System.out.println("Back in my day the games we played were " + halo.getNameGame() + " and " + runescape.getNameGame());

        // Ex 3 - I overloaded the constructor in class OldGame
        // and am creating 3 new objects below using each constructor

        OldGame osrs = new OldGame("OSRS",1000, true);
        OldGame mario = new OldGame("Mario", true);
        OldGame emptyGame = new OldGame();

        // Ex 4, I will create 3 new characters of different classes
        CharClass paladin = new CharClass("Paladin", 10);
        CharClass wizard = new CharClass("Wizard", 5);
        CharClass ranger = new CharClass("Ranger", 2);
        Character myCharacter = new Character("Ncummons", 15, 10, 7, paladin);
        Character haileysCharacter = new Character("Hcummons", 2, 6, 4, ranger);
        Character judesCharacter = new Character("JcummonsPWNZU", 3, 13, 5, wizard);

        System.out.println(myCharacter.toString());
        System.out.println(haileysCharacter.toString());
        System.out.println(judesCharacter.toString());

    }

}
class NewGame{
    private String nameGame;

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public NewGame(String nameGame) {
        this.nameGame = nameGame;
    }
}
class UnrelatedGame{
    private String nameGame;

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public UnrelatedGame(String nameGame) {
        this.nameGame = nameGame;
    }
}

class OldGame{

    String nameGame;
    int hoursPlayed;
    boolean isMultiplayer;

    public OldGame() {
    }

    public OldGame(String nameGame, int hoursPlayed, boolean isMultiplayer) {
        this.nameGame = nameGame;
        this.hoursPlayed = hoursPlayed;
        this.isMultiplayer = isMultiplayer;
    }

    public OldGame(String nameGame, boolean isMultiplayer) {
        this.nameGame = nameGame;
        this.isMultiplayer = isMultiplayer;
    }
}

class Character{

    private String name;
    private int strength;
    private int magic;
    private int agility;
    private CharClass charClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public CharClass getCharClass() {
        return charClass;
    }

    public void setCharClass(CharClass charClass) {
        this.charClass = charClass;
    }

    public Character(String name, int level, CharClass charClass) {
        this.name = name;
        this.charClass = charClass;
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int magic, int agility, CharClass charClass) {
        this.name = name;
        this.strength = strength;
        this.magic = magic;
        this.agility = agility;
        this.charClass = charClass;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", \nstrength=" + strength +
                ", \nmagic=" + magic +
                ", \nagility=" + agility +
                ", \nCharClass=" + charClass.toString() +
                '}';
    }
}

class CharClass{

    private String className;
    private int classLevel;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(int classLevel) {
        this.classLevel = classLevel;
    }

    public CharClass(String className, int classLevel) {
        this.className = className;
        this.classLevel = classLevel;
    }

    @Override
    public String toString() {
        return "CharClass{" +
                "className='" + className + '\'' +
                ", classLevel=" + classLevel +
                '}';
    }
}
