package labs_examples.exception_handling.labs;
import org.omg.CORBA.INITIALIZE;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 2:
 *
 *      Demonstrate a try/catch with multiple catch statements.
 *
 */

class Exercise2{



    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        try{

            // comment out line 27 and uncomment line 26 for division by zero error

            // int quotient = nums[3]/nums[0];
            int quotient = nums[6]/nums[3];
            System.out.println(quotient);
        }catch (ArithmeticException arithmeticException){
            System.out.println("Division by zero error.");
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Array index is out of bounds.");
        }
        System.out.println("Program complete.");
    }


}

