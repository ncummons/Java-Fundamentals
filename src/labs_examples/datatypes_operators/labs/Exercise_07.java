package labs_examples.datatypes_operators.labs;

import java.util.Scanner;

/**
 * Fundamentals Exercise 5: Days to seconds
 *
 *      Take in a number in days from the user between 1 and 1,000,000 and convert it to
 *      seconds.
 *
 *      NOTE: We will be using the Scanner class to collect user input. This is demonstrated below.
 *
 */

public class Exercise_07 {

    public static void main(String[] args) {

        // create scanner
        Scanner scanner = new Scanner(System.in);
        // prompt user
        System.out.print("Enter a number in days between 1 and 1,000,000: ");
        // assign input to variable as int
        int days = scanner.nextInt();

        // write completed code here
        if ((days >= 1) & (days <= 1000000)){
            float hours = days * 60;
            System.out.println("The number of hours in that many days is: " + hours);
            double minutes = hours * 60;
            System.out.println("The number of minutes that many hours is: " + minutes);
            double seconds = minutes * 60;
            System.out.println("The number of seconds in that many minutes is: " + seconds);
        }
        if ((days < 1) | (days > 1000000)){
            System.out.println("You did not enter a number between 1 and 1,000,000.");
        }
    }
}