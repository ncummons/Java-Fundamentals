package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all relational operators below. These include:
 *
 * less than, less than or equal to, greater than, greater than or equal to, and equal to
 *
 */
class RelationalOperators {

    public static void main(String[] args) {

        // example of "less than"
        int a = 1;
        int b = 2;
        if (a < b){
            System.out.println("a is less than b");
        }

        // write your code below
        int x = 10;
        int y = 10;
        System.out.println("x is equal to: " + x + "\n" + "y is equal to: " + y);

        if (x == y){
            System.out.println("x is equal to y");
        }
        x -= 2;
        System.out.println("x is now equal to: " + x);
        if (x < y){
            System.out.println("x is now less than y");
        }
        if (x <= y){
            System.out.println("x is also less than or equal to y");
        }
        x += 2;
        System.out.println("x is now equal to: " + x);

        if (x <= y) {
            System.out.println("x is still less than or equal to y");
        }

        if (x >= y){
            System.out.println("x is also greater than or equal to y");
        }
        x -= 2;
        System.out.println("x is now equal to: " + x);
        if (!(x > y)){
            System.out.println("However, x is not greater than y");
        }

        if (x != y){
            System.out.println("Put quite simply, x is not equal to y");
        }
    }

}

