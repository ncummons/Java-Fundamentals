package labs_examples.lambdas.labs;

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
    T lessBlahFunMethod(T t);
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
        System.out.println(squareRoot.lessBlahFunMethod(16.0));


    }
}