package labs_examples.conditions_loops.labs;

import java.util.Scanner;

/**
 * Conditions and Loops Exercise 5: Calculator
 *
 *      Take two numbers from the user, an upper and lower bound. Using a "for-loop", calculate the sum
 *      of numbers from the lower bound to the upper bound. Also, calculate the average of numbers.
 *      Print the results to the console.
 *
 *      For example, if a user enters 1 and 100, the output should be:
 *
 *      The sum is: 5050
 *      The average is: 50.5
 *
 *
 */

public class Exercise_05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input two numbers below to calculate");
        System.out.println("the sum of the numbers from the lower to the higher");
        System.out.println("and the average of the two numbers: ");

        float x = scanner.nextInt();
        float y = scanner.nextInt();
        float average = ((x + y) / 2);

        if (x < y) {
            for (float count = x; count <= y; count++) {
                x += count;
            }
            System.out.println("The sum of the numbers from the lower to the higher is: " + x);
            System.out.println("The average of the two numbers is: " + average);
        } else if (x > y) {
            for (float count = y; count <= x; count++) {
               y += count;
            }
            System.out.println("The sum of the numbers from the lower to the higher is: " + y);
            System.out.println("The average of the two numbers is: " + average);
        } else {
            System.out.println("The sum of the numbers from the lower to the higher is: " + (x + y));
            System.out.println("The average of the two numbers is: " + average);
        }


    }

}


