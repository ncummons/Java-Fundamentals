package labs_examples.objects_classes_methods.labs.methods;

class MethodTraining {

    public static void main(String[] args) {

        int fakeAge = 26;

        // My primitive data type, fakeAge will be "passed by value" and the method will receive a copy of the value
        // The actual integer, fakeAge is not changed -- just the value passed into the method
        System.out.println("Before running plus1: : " + fakeAge);
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

        System.out.println(maxValue(1235,4,56,4));

        // Return a boolean for a test of whether or not a number is prime:

        System.out.println("25 is prime: " + isPrime(25));
        System.out.println("13 is prime: " + isPrime(13));
        System.out.println("111 is prime: " + isPrime(111));
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
