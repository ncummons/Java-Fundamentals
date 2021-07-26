package labs_examples.datastructures.linkedlist.labs;

/**
 *      LinkedLists - Exercise_03
 *
 *      Please create your own custom doubly-LinkedList from start to finish :) You got this!
 */

class DoublyController {
    public static void main(String[] args) {

        // Testing list - Works as doubly linked

        CustomDoublyLinkedList<String> myList = new CustomDoublyLinkedList<>();
        String[] myArr = {"Four", "Three", "Two", "One", "Zero"};
        myList.addAll(myArr);
        myList.add("New String");
        myList.printAll();
        myList.insert("Popping String", 0);
        String myString = myList.pop();
        System.out.println(myString);
    }
}