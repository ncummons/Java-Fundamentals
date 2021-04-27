package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 5:
 *
 *      Demonstrate how to throw an exception.
 *
 */

class Exercise5{

    public static void main(String[] args) {
        try{
            int x = 0;
            int y = 100;
            int quotient = y/x;
            System.out.println(quotient);
        }catch (ArithmeticException arithmeticException){
            System.out.println("Division by zero error.");
            // Exception here is thrown to the main method and thus to the JVM, so that's a problem
            throw arithmeticException;
        }
    }

}