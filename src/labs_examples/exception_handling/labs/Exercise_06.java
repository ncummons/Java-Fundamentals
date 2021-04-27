package labs_examples.exception_handling.labs;

import java.lang.reflect.Array;

/**
 * Exception Handling Exercise 6:
 *
 *      Demonstrate throwing an exception in one method and catching it in another method.
 *
 */

class Exercise6{

    public static void main(String[] args) {
        try{
            someMethod();
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Caught exception in main method.");
        }
    }


    static void someMethod() throws ArrayIndexOutOfBoundsException {
        int[] nums = {0, 1, 2, 4, 5, 6};
        try{
            int x = nums[19] + nums[1];
            System.out.println(x);
        }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Catching exception in method and throwing.");
            throw arrayIndexOutOfBoundsException;
        }
    }

}

