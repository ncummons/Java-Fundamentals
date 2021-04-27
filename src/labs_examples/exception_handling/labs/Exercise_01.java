package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 1:
 *
 *      1) Demonstrate a try/catch.
 *
 */
class Exercise1{

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 8};
        try{
            for (int i = 0; i < 6; i++){
                System.out.println(nums[i]);
            }
        }catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Oh no! The index is out of bounds!");
        }

    }
}
