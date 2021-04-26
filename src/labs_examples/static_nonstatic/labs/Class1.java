package labs_examples.static_nonstatic.labs;

class Class1 {

    public static void main(String[] args) {
        System.out.println("Working in class 1: ");
        Class1.static2();
        Class1.static1();
        Class1 obj1 = new Class1();
        obj1.nonStatic1();
        obj1.nonStatic2();
        System.out.println("Done with class 1, moving on to class 2: ");
        Class2 obj2 = new Class2();
        Class2.static1();
        Class2.static2();
        obj2.nonStatic1();
        obj2.nonStatic2();
        System.out.println("All done!");

    }

    public void nonStatic1(){
        System.out.println("C1 nonStatic1");
        nonStatic2();
        static1();
        System.out.println("__________________");
    }
    public void nonStatic2(){
        System.out.println("C1 nonStatic2");
        System.out.println("__________________");
    }

    public static void static1(){
        System.out.println("C1 static1");
        Class1 obj = new Class1();
        obj.nonStatic2();
        static2();
        System.out.println("__________________");
    }

    public static void static2(){
        System.out.println("C1 static2");
        System.out.println("__________________");
    }

}



class Class2{

    public void nonStatic1(){
        System.out.println("C2 nonStatic1");
        nonStatic2();
        static1();
        System.out.println("__________________");
    }
    public void nonStatic2(){
        System.out.println("C2 nonStatic2");
        System.out.println("__________________");
    }

    public static void static1(){
        System.out.println("C2 static1");
        Class2 obj = new Class2();
        obj.nonStatic2();
        static2();
        System.out.println("__________________");
    }

    public static void static2(){
        System.out.println("C2 static2");
        System.out.println("__________________");
    }

}
