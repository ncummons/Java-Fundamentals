package labs_examples.conditions_loops.examples.conditional_statements;

public class WhileLoop {
    public static void main(String[] args) {

        int count = 0;


        while (count < 10){
            System.out.println("count is " + count);
            count++;
        }

        System.out.println("all done with while loop!");

        int outerCount = 0;
        int innerCount = 0;

        while (outerCount < 10){
            while (innerCount < 10){
                System.out.println("outer count = " + outerCount + " and inner count = " + innerCount);
                innerCount++;
            }

            innerCount = 0;
            outerCount++;
        }

        System.out.println("all done with nested while loop!");

    }
}
