package labs_examples.arrays.labs;

/**
 *  2D Array
 *
 *      Create and populate a 5x5 2D array with multiples of 3, starting with 3. Once populated, print out the results.
 *
 *      The output should look something like this:
 *
 *      3 6 9 12 15
 *      18 21 24 27 30
 *      ...
 *      ...
 *      ...
 *
 */

public class Exercise_03 {

    public static void main(String[] args) {

        int[][] multiArray = new int[5][5];
        int ongoingSum = 0;

        for(int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                ongoingSum += 3;
                multiArray[i][j] = ongoingSum ;
            }
        }

        for(int[] outer: multiArray){
            for(int values: outer){
                System.out.print(values + " ");
            }
            System.out.println();
        }

    }
}
