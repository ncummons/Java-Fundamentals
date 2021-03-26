package labs_examples.fundamentals.examples;

public class Variables {

    // global variable
    // field
    static double val = 123.45;

    public static void main(String[] args) {

        Person myPerson = new Person("Nicholas", 26);
        Person yourPerson = new Person("Ryan", 36);
        Person einstein = new Person("Einstein", 110);
        Person ellen = new Person("Ellen", 50);

        System.out.println(myPerson.toString());
        System.out.println(yourPerson.toString());
        System.out.println(einstein.toString());
        System.out.println(ellen.toString());

        double x = multiply(val,-2 * 2);
    }
    public static double multiply(double a, double b){
        double result = a * b;

        if (result > 0){
            double testVal = result * 2;
            System.out.println(testVal * val);
        }

        if (result <= 0){
            double testVal2 = result / 2;
            System.out.println(testVal2 / val);
        }

        printNum(result);
        return result;
    }

    public static void printNum(double numToPrint){
        System.out.println(numToPrint);
        System.out.println(val);
    }
}
