package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all arithmetic operators below. These include:
 *
 * addition, subtraction, multiplication, division and modulus
 *
 */
class ArithmeticOperators {

    public static void main(String[] args) {

        // write your code below
        int x = 10;
        int y = 3;
        System.out.println("x = " + x + "\n" + "y = " + y);

        int addition = x + y;
        System.out.println("x + y = " + addition);
        int subtraction = x - y;
        System.out.println("x - y = " + subtraction);
        int multiplication = x * y;
        System.out.println("x * y = " + multiplication);
        int division = x / y;
        int modulus = x % y;
        System.out.println("x / y = " + division + " with remainder " + modulus);
    }
}