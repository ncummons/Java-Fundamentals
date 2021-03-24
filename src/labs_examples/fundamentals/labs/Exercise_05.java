package labs_examples.fundamentals.labs;


import java.sql.SQLOutput;

/**
 * Fundamentals Exercise 5: Working with Strings
 *
 *      Please follow the instructions in the comments below
 *
 */

public class Exercise_05 {

    public static void main(String[] args) {

        String str = "hello!";
        // please declare an int variable below, and set it to the value of the length of "str"
        int x = 6;

        String str2 = "hello";
        // please initialize a boolean variable and test whether str is equal to str2
        boolean EqualTest = str.equalsIgnoreCase(str2);

        // please concatenate str & str2 and set the result to a new String variable below
        String str3 = (str + str2);
        // please demonstrate the use of any other method that is available to us in the String class
        // for example, replace(), substring(), contains(), indexOf() etc
        System.out.println(str3);
        System.out.println(str3.substring(3,6));
        System.out.println(str3.charAt(3));
        System.out.println(str.replace('h', 'y'));
        System.out.println(str2.indexOf("he"));
        System.out.println(str2.contains("lo"));
        boolean str2Boolean = str2.contains("lo");
        System.out.println(str2Boolean);
    }


}