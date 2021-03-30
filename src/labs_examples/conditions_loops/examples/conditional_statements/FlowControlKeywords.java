package labs_examples.conditions_loops.examples.conditional_statements;

public class FlowControlKeywords {

    public static void main(String[] args) {

        // FLOW CONTROL
        // continue, break, return

        // continue
        for(int i = 0; i < 10; i++){
            if (i == 3 || i == 7){
                // forces an early iteration of the loop
                continue;
            }
            System.out.println("i = " + i);
        }

        System.out.println("done with continue loop");

        // break
        for(int i = 0; i < 10; i++) {
            if (i == 3 || i == 7) {
                break;
            }
            System.out.println("i = " + i);
        }

        System.out.println("done with loop");

        int i = someMethod(1);
        System.out.println("i = " + i);

    }
// Return
    public static int someMethod(int val){

        if (val == 0){
            System.out.println("1) will this print?");
            return 0;
            // return exits the current method (will return a value if the method requires)
        } else if (val == 1){
            System.out.println("2) will this print?");
            return 1;
            // return exits the current method (will return a value if the method requires)
        }
        System.out.println("3) will this print?");
        return -1;
        // return exits the current method (will return a value if the method requires)

    }

}
