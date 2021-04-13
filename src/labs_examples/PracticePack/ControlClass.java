package labs_examples.PracticePack;
import java.util.Scanner;

public class ControlClass {



    public static void main(String[] args) {

        // First method sums all numbers in an int array that are even, skipping those that are odd.
        // Initial input is length of array, following inputs are populating the array
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the length of numbers you'd like to enter between 1 and 20: ");
        int x = scanner.nextInt();
        int arrLength = 0;
        if(x <= 20 && x >= 1){
            arrLength += x;
        }else{
            System.out.println("Invalid number: Please try again.");
            return;
        }

        int[] intArr = new int[arrLength];
        for(int i = 0; i < arrLength; i++){
            intArr[i] = scanner.nextInt();
        }

        System.out.println("The sum of all even numbers you just entered is: " + sumEvens(intArr));

    }

    static int sumEvens(int[] intArr){
        int sum = 0;
        for(int x : intArr){
            if(x % 2 == 0){
                sum += x;
            }
        }
        return sum;
    }

}
