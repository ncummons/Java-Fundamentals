package labs_examples.arrays.labs;
import  java.util.Scanner;

/**
 *  More labs_examples.arrays
 *
 *      Using the array below, take in a number from 1-10 from the user and print out the index of that
 *      element.
 *
 */

public class Exercise_02 {

    public static void main(String[] args) {

        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("The array that we are working with is: ");
        for(int vals : array) {
            System.out.print(vals + " | ");
        }
        System.out.println();
        // write code here

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please input a number between 1 and 10 to choose an element: ");
        int x = keyboard.nextInt() - 1;
        if(x >= 0 && x <= 9){
            System.out.println(array[x]);
        }else{
            System.out.println("Invalid entry. Please try again.");
        }


    }
}