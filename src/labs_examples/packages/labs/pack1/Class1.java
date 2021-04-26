package labs_examples.packages.labs.pack1;

import labs_examples.packages.labs.pack2.Class2;

public class Class1 {

    public static void main(String[] args) {
        Class1 class1 = new Class1();
        // Importing class2 to create object
        Class2 class2 = new Class2();

        class1.method1A();
        class1.method2A();
        // executable because it has "protected" access modifier and is a subclass of class, even in a diff package
        class2.method2A();
        // non-executable because it has "default" access modifier, and thus is not visible to class2 in pack2
        // class2.method1A();
    }

    void method1A(){
        System.out.println("Running method1A only in pack1 class1.");
    }

    protected void method2A(){
        System.out.println("Running through a protected method in pack1.Class1");
    }

}
