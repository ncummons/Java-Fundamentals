package labs_examples.exception_handling.labs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 4:
 *
 *      Demonstrate a nested try/catch.
 *
 */

class Exercise4{
    // Choose two indices of the array to divide and find their quotient

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3, 4, 5};
        Scanner scanner = new Scanner(System.in);
        try {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            try {
                int quotient = nums[x] / nums[y];
                System.out.println(quotient);
            } catch (ArithmeticException arithmeticException) {
                System.out.println("Division by zero error.");
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                System.out.println("Array index is out of bounds.");
            }
        } catch (InputMismatchException inputMismatchException){
            System.out.println("Invalid input");
        }
        System.out.println("Program complete.");
    }
}