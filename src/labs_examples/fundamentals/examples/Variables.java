package labs_examples.fundamentals.examples;

public class Variables {

    // global variable
    // field
    static double val = 123.45;

    public static void main(String[] args) {
        double x = multiply(val,val * 2);
    }
    public static double multiply(double a, double b){
        double result = a * b;
        printNum(result);
        return result;
    }

    public static void printNum(double numToPrint){
        System.out.println(numToPrint);
        System.out.println(val);
    }
}
