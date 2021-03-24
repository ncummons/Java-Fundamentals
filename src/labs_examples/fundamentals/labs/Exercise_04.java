package labs_examples.fundamentals.labs;

/**
 * Fundamentals Exercise 4: My Second Program
 *
 *      Write the necessary code to display, declare and print each of Java's primitive data types.
 *      Please declare a single variable of each type, give it an appropriate value, then print that variable.
 *
 */

public class Exercise_04 {

    public static void main(String[] args) {

        boolean isTrue = true;
        System.out.println("isTrue = " + isTrue);

        char letter = 'G';
        System.out.println("char = " + letter);

        byte SmallNumber = 12;
        System.out.println("byte = " + SmallNumber);

        short MediumNumber = 15000;
        System.out.println("MediumNumber = " + MediumNumber);

        int MaxCashStack = 2147483647;
        System.out.println("I now understand that in OSRS the max cash stack is: " + MaxCashStack + " because it is a Java-based game and they use an int value for the coin system. Neat.");

        long BigNumber = 500000000;
        System.out.println("BigNumber = " + BigNumber);

        float DecimalNumber = 12.1845f;
        System.out.println("DecimalNumber = " + DecimalNumber);

        double PreciseDecimal = 12.18449375618;
        System.out.println("PreciseDecimal = " + PreciseDecimal);

    }

}
