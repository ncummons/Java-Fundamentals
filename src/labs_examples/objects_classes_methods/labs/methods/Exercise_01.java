package labs_examples.objects_classes_methods.labs.methods;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Exercise_01 {

    public static void main(String[] args) {

        // please create the methods as instructed below then
        // call each of those methods from here, within the main()
        System.out.println("6 times 12 is: " + multiply(6, 12));
        System.out.println("900 divided by 6 is: " + divide(900, 6));
        joke();
        System.out.println("There are " + secondsInYear(5) + " seconds in 5 years.");
        System.out.println("There are " + howManyInputs("1", "2", "3", "4") + " inputs.");

    }


    // 1) Create a static multiply() method below that takes two int arguments (int a, int b) and
    //    returns the result of a * b

    static int multiply(int a, int b){
        return a * b;
    }


    // 2) Create a static divide() method below that takes two int arguments (int a, int b) and
    //    returns the result of a / b

    static int divide(int a, int b){
        if(b != 0){
            return a / b;
        }else{
            System.out.println("Divide by zero error");
            return -1;
        }

    }


    // 3) Create a static void method that will print of joke of your choice to the console

    static void joke(){
        System.out.println("I'd like to give a shout out to the sidewalks...\nfor keeping me off the streets!");
    }


    // 4) Create a static method that takes in a number in years (int years) as an argument
    //    and returns the number of seconds that number in years represents

    static double secondsInYear(double years){
        return years * 60 * 60 * 24 * 365;
        // 31,556,952 seconds per year according to siri... my calc above has it at: 31,536,000
    }


    // 5) Create a varargs method that will return the length of the varargs array passed in

    static int howManyInputs(String...arg){
        return arg.length;
    }






}
