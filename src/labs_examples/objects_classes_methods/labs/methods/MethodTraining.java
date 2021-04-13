package labs_examples.objects_classes_methods.labs.methods;

import java.util.ArrayList;

class MethodTraining {

    public static void main(String[] args) {

        int fakeAge = 26;

        // My primitive data type, fakeAge will be "passed by value" and the method will receive a copy of the value
        // The actual integer, fakeAge is not changed -- just the value passed into the method
        System.out.println("Before running plus1: : " + fakeAge);
        System.out.print("Running plus1: ");
        plus1(fakeAge);
        System.out.println("After: " + fakeAge);

        /* Here, the actual object, myPerson, is being "passed by reference" because the method is pointing
        to a reference point of memory for the object and changing it there -- the method does NOT get
        a copy of the object */

        Person myPerson = new Person(29, "Nicholas");
        System.out.println(myPerson.toString());
        myPerson.changeAge(-3);
        System.out.println("I should be three years younger: \n" + myPerson.toString());

        // Print out the max value of 4 numbers:

        System.out.println(maxValue(1235, 4, 56, 4));

        // Return an integer value for how many consonants are in a string

        System.out.println("There are 20 Consonants in this string: " + countConsonants("There are 20 Consonants in this string"));

        // Return a boolean for a test of whether or not a number is prime:

        System.out.println("25 is prime: " + isPrime(25));
        System.out.println("13 is prime: " + isPrime(13));
        System.out.println("111 is prime: " + isPrime(111));

        // Return a minimum and maximum value as an int array from a separate int array

        int[] givenArray = {1, 2, 3, 4, 5, 6, 78, 8, -12, 10};
        System.out.println("The min and mix of: 1, 2, 3, 4, 5, 6, 78, 8, -12, 10 are respectively: ");
        int[] minMaxArr = minMax(givenArray);
        for (int x = 0; x < minMaxArr.length; x++) {
            System.out.print(minMaxArr[x] + " | ");
        }
        System.out.println();

        // Returning int array list for nums divisible by both divisors b/w 0 and max num

        ArrayList<Integer> newArrList = divisibleBy(100, 10, 5);
        System.out.println("This new list has " + newArrList.size() + " elements.");
        for (int vals : newArrList) {
            System.out.print(vals + " | ");
        }
        System.out.println();

        // Takes in an integer array and reverses it (one used one extra temp variable)

        int[] valueArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Here is the original array: ");
        for (int intVals : valueArray) {
            System.out.print(intVals + " | ");
        }
        System.out.println();
        System.out.print("The new reversed array is: ");
        valueArray = reverseIntArr(valueArray);
        for (int intVals : valueArray) {
            System.out.print(intVals + " | ");
        }
        System.out.println();
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    // Overloading method sum()
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static void plus1(int num) {
        num += 1;
        System.out.println(num);
    }

    // Thought of this after, could I have used a switch statement? I'm not entirely sure I could have
    public static int maxValue(int a, int b, int c, int d){
        if(a >= b & a >= c & a >= d){
            return a;
        }else if(b >= a & b >= c & b >= d){
            return b;
        }
        else if(c >= a & c >= b & c >= d) {
            return c;
        }else{
            return d;
        }
    }

    public static int countConsonants(String string){
        int sum = 0;
        String consonants = "qwrtypsdfghjklzxcvbnmQWRTYPSDFGHJKLZXCVBNM";
        char[] charArray = string.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            for(int j = 0; j < consonants.length(); j++) {
                if (charArray[i] == consonants.charAt(j)) {
                    sum += 1;
                }else{
                    continue;
                }
            }
        }
        return sum;
    }

    public static boolean isPrime(int x){
        for(int i = 2; i < x/2; i++){
            if(x % i == 0){
                return false;
            }else{
                continue;
            }
        }
        return true;
    }

    public static int[] minMax(int[] intArr){
        int maxValue = intArr[0];
        int minValue = intArr[0];
        for(int i = 1; i < intArr.length; i++){
            if(intArr[i] > maxValue){
                maxValue = intArr[i];
            }
        }
        for(int i = 1; i < intArr.length; i++){
            if(intArr[i] < minValue){
                minValue = intArr[i];
            }
        }
        int[] newArr = {minValue, maxValue};
        return newArr;
    }

    public static ArrayList<Integer> divisibleBy(int maxNum, int divisor1, int divisor2){
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for(int i = 1; i < maxNum; i++){
            if((i % divisor1 == 0) & (i % divisor2 == 0)){
                integerArrayList.add(i);
            }
        }
        return integerArrayList;
    }

    public static int[] reverseIntArr(int[] intArr){
        int temp;
        for(int i = 0; i < intArr.length / 2; i++){
            temp = intArr[i];
            intArr[i] = intArr[intArr.length - 1 - i];
            intArr[intArr.length - 1 - i] = temp;
        }
        return intArr;
    }

public static class Person {

    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void changeAge(int years) {
        this.age += years;
    }
}

}
