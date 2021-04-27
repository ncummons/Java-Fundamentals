package labs_examples.exception_handling.labs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 3:
 *
 *      Demonstrate a try/catch/finally block.
 *
 */

class Exercise3{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try{
            int x = sum(scanner.nextInt(), scanner.nextInt());
            System.out.println(x);
        } catch (InputMismatchException inputMismatchException){
            System.out.println("Invalid input.");
        } finally {
            // always executes.
            System.out.println("Thanks and have a great day!");
        }


        System.out.println("Program complete.");

    }

    static int sum(int a, int b){
        return a+b;
    }

}