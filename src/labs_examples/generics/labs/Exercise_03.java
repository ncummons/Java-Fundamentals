package labs_examples.generics.labs;

import java.util.*;


/**
 * Generics Exercise 3:
 *
 *      1) Write a generic method that accepts two generic arguments. This generic method should only accept
 *      arguments which are sublasses of Number. The generic method must return the sum (as a double) of whatever two
 *      numbers were passed in regardless of their type.
 *
 *      2) Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes

 *      3) Write a generic method to exchange the positions of two different elements in an array.
 *
 *      4) Write a generic method to find the largest element within the range (begin, end) of a list.
 *
 */

class ControlClass3{
    public static void main(String[] args) {
        System.out.println(GenMethods2.sumNums(2.5, 5.1f));
        System.out.println(GenMethods2.sumNums(5,1.2));

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Wow");
        stringArrayList.add("mom");
        stringArrayList.add("nursesrun");
        stringArrayList.add("word");
        stringArrayList.add("me");

        System.out.println(GenMethods2.countPalindromes(stringArrayList));
        String[] stringArr = {"Wow", "mom", "nursesrun", "word", "me"};
        for (String word: stringArr){
            System.out.print(word + " | ");
        }
        System.out.println();
        stringArr = GenMethods2.switchElements(stringArr,0,2);
        for (String word: stringArr){
            System.out.print(word + " | ");
        }
        System.out.println();

        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(15);
        arrayList.add(1);
        arrayList.add(25);
        arrayList.add(4);
        System.out.println("The max of the list is: " + GenMethods2.findMax(arrayList));
        ArrayList<Double> doubleArrayList = new ArrayList();
        doubleArrayList.add(0.15);
        doubleArrayList.add(0.1);
        doubleArrayList.add(0.25);
        doubleArrayList.add(0.4);
        System.out.println("The max of the list is: " + GenMethods2.findMax(doubleArrayList));

    }
}

class GenMethods2{

    public static <T extends Number, V extends Number> double sumNums(T t, V v){
        return t.doubleValue() + v.doubleValue();
    }

    // count the number of elements in a "Collection" of Strings that are palindromes

    public static <C extends Collection> int countPalindromes(C collection){
        int countPals = 0;
        for(Object element: collection){
            int palValidation = 0;
            String thisElement = element.toString().toLowerCase(Locale.ROOT);
            char[] charArr = thisElement.toCharArray();
            for(int i = 0; i < Math.floorDiv(charArr.length,2); i++){
                if(charArr[i] == charArr[charArr.length-(i+1)]){
                    palValidation++;
                }
            }
            if(palValidation == Math.floorDiv(charArr.length,2)){
                countPals++;
            }

        }
        return countPals;
    }

    // exchange the positions of two different elements in an array

    public static <E> E[] switchElements(E[] arrToManipulate, int firstIndexToSwitch, int secondIndexToSwitch){
        System.out.println("The original array is: ");
        for(E element : arrToManipulate){
            System.out.print(element + " | ");
        }
        System.out.println();
        E tempVal = arrToManipulate[firstIndexToSwitch];
        arrToManipulate[firstIndexToSwitch] = arrToManipulate[secondIndexToSwitch];
        arrToManipulate[secondIndexToSwitch] = tempVal;
        System.out.println("The manipulated array is: ");
        for(E element : arrToManipulate){
            System.out.print(element + " | ");
        }
        System.out.println();
        return arrToManipulate;
    }

    // to find the largest element within the range (begin, end) of a list.

    public static <L extends List, N extends Number> double findMax(List<N> nums){
        Iterator<N> it = nums.iterator();
        double max = nums.get(0).doubleValue();
        double tempNum;
        while(it.hasNext()){
            tempNum = it.next().doubleValue();
            if (tempNum > max){
                max = tempNum;
            }
        }
        return max;
    }


}