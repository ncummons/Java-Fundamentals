package labs_examples.arrays.labs;
import java.util.Scanner;

/**
 *  Irregular Arrays
 *
 *      Create and populate a 2 dimensional irregular array of size and contents of your choosing. Using a nested
 *      "for-each" loop, iterate and print out each element of the array.
 *
 *      I also added a feature to select new words while maintaining the same irregular array structure.
 */

public class Exercise_04 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String[][] irregStrings = {

                {"Zelda", "music", "rocks!"},
                {"Irregular", "array."},
                {"This", "is", "a", "longer", "list", "of", "strings."}
        };

       for(String[] outer: irregStrings){
           for(String words: outer){
               System.out.print(words + " ");
           }
           System.out.println();
       }
        System.out.println("You may change the words of the three lines now: ");
        for(int j = 0; j < irregStrings.length; j++){
            System.out.println("Please choose the words for line " + (j + 1) + ": ");
            for(int i = 0; i < irregStrings[j].length; i++){
                irregStrings[j][i] = keyboard.next();
            }
        }

        for(String[] outer: irregStrings){
            for(String words: outer){
                System.out.print(words + " ");
            }
            System.out.println();
        }

    }

}
