package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 7:
 *
 *      1) Create a custom exception.
 *      2) Demonstrate a method throwing your custom exception.
 */

class Exercise7{

    public static void main(String[] args) {
        try{
            someMethod(101);
        }catch (CustomException customException){
            System.out.println("Caught custom exception.");
        }
    }

    static void someMethod(int people) throws CustomException{
        int numPeople = 0;
        numPeople += people;
        System.out.println("There are " + numPeople + " people in the building.");
        if(numPeople > 100){
            System.out.println("There are too many people for the building to handle.");
            throw new CustomException();
        }
    }

}
class CustomException extends Exception{
    @Override
    public String toString() {
        return "CustomException{Custom exception message would go here.}";
    }
}
