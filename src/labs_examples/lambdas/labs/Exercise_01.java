package labs_examples.lambdas.labs;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Lambdas Exercise 1:
 *
 *      1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
 *      2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
 *          value of the same type as the parameter
 *      4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
 *          value
 *      6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.
 *
 *
 *
 *
 */

// 1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void

@FunctionalInterface
interface BlahExampleFunc{
    void blahFuncMethod();
}

// 3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
//    value of the same type as the parameter

@FunctionalInterface
interface LessBlahExampleFunc<T>{
    T lessBlahFuncMethod(T t);
}

// 5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
//    value

@FunctionalInterface
interface WayLessBlahExampleFunc<T, U, V>{
    V wayLessBlahFuncMethod(T t, U u);
}

 // 2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 // an anonymous inner class from this interface.

class BlahFuncController{
    public static void main(String[] args) {
        // lambda expression example
        BlahExampleFunc sayHi = () -> System.out.println("Hello there!");
        sayHi.blahFuncMethod();
        // anonymous inner class example
        BlahExampleFunc sayGoodbye = new BlahExampleFunc() {
            @Override
            public void blahFuncMethod() {
                System.out.println("Goodbye, old friend.");
            }
        };
        sayGoodbye.blahFuncMethod();
 //       4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 //          an anonymous inner class from this interface.
        LessBlahExampleFunc<Double> squareRoot = x -> Math.sqrt(x);
        System.out.println(squareRoot.lessBlahFuncMethod(16.0));

        // Anonymous inner class example

        LessBlahExampleFunc<Integer> squareInt = new LessBlahExampleFunc<Integer>() {
            @Override
            public Integer lessBlahFuncMethod(Integer integer) {
                return integer*integer;
            }
        };
        System.out.println(squareInt.lessBlahFuncMethod(5));

        // 6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
        //    an anonymous inner class from this interface.

        WayLessBlahExampleFunc<String, Integer, Character> findCharAt = (word, x) -> word.charAt(x);
        System.out.println(findCharAt.wayLessBlahFuncMethod("I am incredibly happy today!", 8));

        // Anonymous inner class example

        WayLessBlahExampleFunc<Integer, Integer, Double> divisionIntsToDoub = new WayLessBlahExampleFunc<Integer, Integer, Double>() {
            @Override
            public Double wayLessBlahFuncMethod(Integer integer, Integer integer2) {
                return (double)integer/(double)integer2;
            }
        };
        System.out.println(divisionIntsToDoub.wayLessBlahFuncMethod(15,2));

        // 7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.

        Predicate<Integer> isLessThanFifty = x -> x < 50;
        System.out.println(isLessThanFifty.test(49));
        System.out.println(isLessThanFifty.test(51));

        BiFunction<Integer, ArrayList<String>, String> getStringAtIndex = (x, arrList) -> arrList.get(x);

        ArrayList<String> myList = new ArrayList<>();
        myList.add("Happy");
        myList.add("Sad");
        myList.add("Angry");
        myList.add("Joyous");
        myList.add("Ecstatic");
        myList.add("Bored");

        System.out.println(getStringAtIndex.apply(4, myList));




    }
}