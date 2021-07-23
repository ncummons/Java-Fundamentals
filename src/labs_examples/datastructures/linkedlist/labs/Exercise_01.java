package labs_examples.datastructures.linkedlist.labs;

import java.util.*;

/**
 *      LinkedLists - Exercise_01
 *
 *      Demonstrate your mastery of Java's built-in LinkedList class by demonstrating the following:
 *
 *          1) create a LinkedList (from Java's libraries)
 *          2) add()
 *          3) addAll()
 *          4) addFirst()
 *          5) addLast()
 *          6) getFirst()
 *          7) getLast()
 *          8) get()
 *          9) set()
 *          10) push()
 *          11) pop()
 *          12) remove()
 *          13) contains()
 *          14) listIterator()
 *      15) clear()
 */


class Ex1{
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("Jude");
        myList.add("Joseph");
        myList.add("Cummons");
        ArrayList<String> myArrList = new ArrayList<>();
        myArrList.add("is");
        myArrList.add("the");
        myArrList.add("best!");
        myList.addAll(myArrList);
        myList.addFirst("My son,");
        myList.addLast("For real!");
        String myString = myList.getFirst();
        System.out.println(myString);
        myString = myList.getLast();
        System.out.println(myString);
        String name = myList.get(1);
        System.out.println(name);
        myList.set(0,"First String.");
        myList.push("New First String.");
        String takingString = myList.pop();
        System.out.println(takingString);
        myList.remove();
        if(myList.contains(name)){
            System.out.println(name);
        }else{
            System.out.println("Name does not exist.");
        }
        Iterator<String> myIt = myList.listIterator();
        while(myIt.hasNext()){
            System.out.println(myIt.next());
        }
        myList.clear();
        // Will not print anything out.
        Iterator<String> myNewIt = myList.listIterator();
        while(myNewIt.hasNext()){
            System.out.println(myNewIt.next());
        }
    }
}