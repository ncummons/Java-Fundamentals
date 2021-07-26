package labs_examples.datastructures.stack.labs;

import java.util.Arrays;
import java.util.Stack;

/**
 *      Demonstrate your mastery of Java's built-in Stack class by completing the following:
 *
 *      1) instantiate a new Stack
 *      2) demonstrate the use of EVERY method in the Stack class - there are 5
 */

class StackPractice1{
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();
        String[] myArr = {"Nicholas", "Hailey", "Jude", "Lucy", "Cummons"};
        myStack.addAll(Arrays.asList(myArr));
        myStack.push("Extra String");
        int index = 0;
        for(String element : myStack){
            System.out.println(index + ": " + element);
            index++;
        }
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        int depth = myStack.search("Jude");
        System.out.println(depth);
        myStack.empty();
        System.out.println(myStack.isEmpty());
    }
}
