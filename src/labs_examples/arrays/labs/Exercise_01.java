package labs_examples.arrays.labs;

import java.util.Scanner;

/**
 * Arrays calculator
 *
 *      Take in 10 numbers from the user. Place the numbers in an array. Using the loop of your choice,
 *      calculate the sum of all of the numbers in the array as well as the average.
 *
 *      Print the results to the console.
 *
 */

public class Exercise_01 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int[] nums = new int[10];

        System.out.println("Please input 10 numbers:");

        for(int i = 0; i < nums.length; i++){
            nums[i] = keyboard.nextInt();
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        System.out.println("The sum of these numbers is: " + sum);
        System.out.println("The average of these numbers is: " + (sum/nums.length));
    }

}