package labs_examples.lambdas.labs;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Lambdas Exercise 3:
 *
 *      1) Demonstrate the use of a static method reference
 *      2) Demonstrate the use of an instance method reference
 *      3) Demonstrate the use of a constructor reference
 *
 */

class MainClass{
    public static void main(String[] args) {

        // 1) Demonstrate the use of a static method reference
        UnaryOperator<Integer> addTen = ExampleMethods::exampleStaticMethod;
        System.out.println(addTen.apply(1));

        // 2) Demonstrate the use of an instance method reference
        ExampleMethods obj1 = new ExampleMethods(5);
        UnaryOperator<Integer> multiplyVal1By = obj1::exampleInstanceMethod;
        System.out.println(obj1.exampleInstanceMethod(10));

        // 3) Demonstrate the use of a constructor reference

        Supplier<ExampleMethods> createExample = ExampleMethods::new;
        ExampleMethods myNewExample = createExample.get();
        myNewExample.val1 = 10;
        System.out.println(addTen.apply(myNewExample.val1));

    }
}

class ExampleMethods{

    int val1;

    static int exampleStaticMethod(int x){
        return x + 10;
    }

    int exampleInstanceMethod(int x){
        return val1 * x;
    }

    public ExampleMethods(int val1) {
        this.val1 = val1;
    }

    public ExampleMethods() {
    }
}