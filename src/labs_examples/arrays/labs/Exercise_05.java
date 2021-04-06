package labs_examples.arrays.labs;

/**
 *  Traversing Arrays Backwards
 *
 *      Please create and populate an array of your choosing. Then, please demonstrate how to print out every other
 *      element in the array in reverse order.
 *
 */

public class Exercise_05 {

    public static void main(String[] args) {

        int[] intArray = new int[10];

        for(int i = 0; i < intArray.length; i++){
            intArray[i] = (i + 1) * 2;
        }

        // array printed out for reference:
        for(int vals: intArray){
            System.out.print(vals + " | ");
        }

        System.out.println();
        // array printed out backwards and every other element
        for(int i = intArray.length - 1; i >= 0; i -= 2){
            System.out.print(intArray[i] + " | ");
        }

    }

}
