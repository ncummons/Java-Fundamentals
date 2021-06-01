package labs_examples.enumerations.labs;

/**
 * Enumerations Exercise 1:
 *
 *      1) Create an enumeration. Use a controller class to demonstrate the use of the enum from a separate class.
 *      2) Create a parameterized enumeration that passes one or more values to it's constructor. Demonstrate the use
 *      of this enum from a separate class.
 */

enum LevelDifficulty{
    EASY,
    MEDIUM,
    HARD,
    LEGENDARY;


}

enum EnemyCharacter{
    GOBLIN(10,4,"club"),
    SPIDER(6,3,"fangs"),
    COW(8,1,"hooves"),
    MAN(15,10,"sword"),
    RAT(1,1,"teeth");

    private final int hp;
    private final int strength;
    private final String weapon;

    private EnemyCharacter(int hp, int strength, String weapon) {
        this.hp = hp;
        this.strength = strength;
        this.weapon = weapon;
    }

}

class ControllerClass01{

    public static void main(String[] args) {
        LevelDifficulty difficulty = LevelDifficulty.LEGENDARY;

        System.out.println("The difficulty is set to: " + difficulty);

        EnemyCharacter enemy1 = EnemyCharacter.GOBLIN;
        EnemyCharacter enemy2 = EnemyCharacter.COW;
        EnemyCharacter enemy3 = EnemyCharacter.MAN;

        System.out.println("You are fighting: a " + enemy1 + ", a " + enemy2 + ", & a " + enemy3);
    }

}