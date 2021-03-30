package labs_examples.conditions_loops.examples.conditional_statements;

public class ForLoop {

    public static void main(String[] args) {

        // for(initialization; (boolean) condition; iterator)
        for(int i = 0; i < 10; i++){
            System.out.println("i = " + i);
            for(int x = 0; x < 10; x++){
                System.out.println("-- x = " + x);
            }
        }

    }

}
