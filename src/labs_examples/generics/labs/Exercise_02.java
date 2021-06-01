package labs_examples.generics.labs;

import java.util.ArrayList;

/**
 * Generics Exercise 2:
 *
 *      Create a class with a generic method that takes in an ArrayList of any Numeric type and returns the sum of all
 *      Numbers in the ArrayList
 */

class ControlClass02{
    public static void main(String[] args) {
        ArrayList<Integer> intArrL = new ArrayList<>();
        for(int j = 0; j < 10; j++) {
            intArrL.add(j*2);
        }
        System.out.println(GenMethod.sumArr(intArrL));
        ArrayList<Double> doubleArrL = new ArrayList<>();
        for(double j = 0; j < 10; j++) {
            doubleArrL.add(j+0.5);
        }
        System.out.println(GenMethod.sumArr(doubleArrL));
    }
}

class GenMethod{

    public static <T extends Number> int sumArr(ArrayList<T> tArrayList){
        int sum = 0;
        for(int i = 0; i < tArrayList.size(); i++){
            sum += tArrayList.get(i).intValue();
        }
        return sum;
    }

}