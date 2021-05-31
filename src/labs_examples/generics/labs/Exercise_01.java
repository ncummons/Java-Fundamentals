package labs_examples.generics.labs;

/**
 * Generics Exercise 1:
 *
 *      1.) Write a generic class with at least two instance variables, a constructor, and getter and setter methods.
 *      2.) Create a few objects of your generic class with different data types to demonstrate it's
 *          dynamic usage.
 */

class MainControl{
    public static void main(String[] args) {
        GenericExample gen1 = new GenericExample("Awesome", "Cool");
        System.out.println(gen1.getVal1());
        System.out.println(gen1.getVal2());

        GenericExample gen2 = new GenericExample("One", 1f);
        System.out.println(gen2.getVal1());
        System.out.println(gen2.getVal2());
    }
}

class GenericExample <T, V>{

    T val1;
    V val2;

    public GenericExample(T val1, V val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public T getVal1() {
        return val1;
    }

    public void setVal1(T val1) {
        this.val1 = val1;
    }

    public V getVal2() {
        return val2;
    }

    public void setVal2(V val2) {
        this.val2 = val2;
    }
}