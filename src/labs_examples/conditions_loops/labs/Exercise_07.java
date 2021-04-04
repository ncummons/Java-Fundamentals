package labs_examples.conditions_loops.labs;

import java.util.Scanner;

/**
 * Conditions and Loops Exercise 7: First vowel
 *
 *      Take in a word from the user and using a "while" loop, find the first vowel in the word.
 *      Once you find the vowel, print out the word and the first vowel.
 *
 *      Hints:
 *          - there are a few helpful methods in the String class called length(), charAt() and indexOf()
 *          - you'll likely want to use a String that contains all the vowels:
 *              - ie: String vowels = "aeiou";
 *
 */

public class Exercise_07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String vowels = "aeiou";

        System.out.println("Please type a word here to find its first vowel (excluding y): ");

        String input = scanner.next();
        int i = 0;

        while(i < input.length()){
            if(vowels.indexOf(input.charAt(i)) != -1){
                System.out.println(input.charAt(i));
                System.out.println(input);
                break;
            }else{
                i++;
            }
        }

        System.out.println("While loop is done. I did it!");

       // See below for my first attempt, which was much less efficient:

       /** char letter;
        int letterCounter = 0;

        System.out.println("Please type a word here to find its first vowel (excluding y): ");

        String input = scanner.next();

        while(input.length() > 0){
            letter = input.charAt(letterCounter);
            if(letter == 'a'){
                System.out.println("The first vowel is: a\n" + "In the word: " + input);
            }else if(letter == 'e'){
                System.out.println("The first vowel is: e\n" + "In the word: " + input);
            }else if(letter == 'i'){
                System.out.println("The first vowel is: i\n" + "In the word: " + input);
            }else if(letter == 'o'){
                System.out.println("The first vowel is: o\n" + "In the word: " + input);
            }else if(letter == 'u'){
                System.out.println("The first vowel is: u\n" + "In the word: " + input);
            }else{
                letterCounter++;
                continue;
            }
            input = "";
        }

        System.out.println("While loop is done."); */

    }

}
