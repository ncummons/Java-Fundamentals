package labs_examples.datastructures.hashmap.labs;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 *      HashMaps Exercise_03
 *
 *      Create a new class that does the following:
 *
 *      1) create a LinkedList
 *      2) create a Stack
 *      3) create a Queue
 *      4) create a HashMap
 *
 *      Then, add millisecond timers before and after each data structure above and print out
 *      how long it takes for each to complete EACH the following tasks, and the total time for
 *      each data structure:
 *
 *      1) add 10000 elements
 *      2) update 10000 elements
 *      3) search for 10000 elements
 *      4) delete 10000 elements
 */

class DataStructureController{
    public static void main(String[] args) {
        DataStructureCreator myCreator = new DataStructureCreator();
        myCreator.addElements();
        myCreator.updateElements();
        myCreator.searchForElements();
        myCreator.deleteElements();
        myCreator.printDeltas();
    }
}

class DataStructureCreator{
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private Stack<Integer> stack = new Stack<>();
    private PriorityQueue<Integer> priorityQueue= new PriorityQueue<>();
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    private long linkedListDelta = 0;
    private long stackDelta = 0;
    private long queueDelta = 0;
    private long hashMapDelta = 0;

    public void addElements(){
        // LinkedList
        Instant before = Instant.now();
        for(int i = 0; i < 10000; i++){
            linkedList.add(i*42);
        }
        Instant after = Instant.now();
        long delta = Duration.between(before, after).toNanos();
        linkedListDelta += delta;
        System.out.println("Adding 10000 elements to the LinkedList took: " + delta + " nanoseconds.");
        // Stack
        before = Instant.now();
        for(int i = 0; i < 10000; i++){
            stack.add(i*31);
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        stackDelta += delta;
        System.out.println("Adding 10000 elements to the Stack took: " + delta + " nanoseconds.");
        // Queue
        before = Instant.now();
        for(int i = 0; i < 10000; i++){
            priorityQueue.add(i*12);
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        queueDelta += delta;
        System.out.println("Adding 10000 elements to the Queue took: " + delta + " nanoseconds.");
        // HashMap
        before = Instant.now();
        for(int i = 0; i < 10000; i++){
            hashMap.put(i, i*10000);
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        hashMapDelta += delta;
        System.out.println("Adding 10000 elements to the HashMap took: " + delta + " nanoseconds.");
    }

    public void updateElements(){
        // LinkedList
        Instant before = Instant.now();
        for(int i = 0; i < 10000; i++) {
            linkedList.set(i, (i*13));
        }
        Instant after = Instant.now();
        long delta = Duration.between(before, after).toNanos();
        linkedListDelta += delta;
        System.out.println("Updating 10000 elements in the LinkedList took: " + delta + " nanoseconds.");
        // Stack
        before = Instant.now();
        for(int i = 0; i < 10000; i++){
            stack.set(i,(i*15));
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        stackDelta += delta;
        System.out.println("Updating 10000 elements in the Stack took: " + delta + " nanoseconds.");
        // Queue
        before = Instant.now();
        for(int i : priorityQueue){
             i++;
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        queueDelta += delta;
        System.out.println("Updating 10000 elements in the Queue took: " + delta + " nanoseconds.");
        // HashMap
        before = Instant.now();
        for(int i = 0; i < 10000; i++){
            hashMap.replace(i, (hashMap.get(i)*16));
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        hashMapDelta += delta;
        System.out.println("Updating 10000 elements in the HashMap took: " + delta + " nanoseconds.");
    }

    public void searchForElements(){
        // LinkedList
        Instant before = Instant.now();
        for(int i = 0; i < 10000; i++) {
            boolean search = linkedList.contains(i*13);
        }
        Instant after = Instant.now();
        long delta = Duration.between(before, after).toNanos();
        linkedListDelta += delta;
        System.out.println("Searching 10000 elements in the LinkedList took: " + delta + " nanoseconds.");
        // Stack
        before = Instant.now();
        for(int i = 0; i < 10000; i++){
            boolean search = stack.contains(i*15);
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        stackDelta += delta;
        System.out.println("Searching 10000 elements in the Stack took: " + delta + " nanoseconds.");
        // Queue
        before = Instant.now();
        for(int i = 0; i < 10000; i++){
            boolean search = priorityQueue.contains(i*12);
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        queueDelta += delta;
        System.out.println("Searching 10000 elements in the Queue took: " + delta + " nanoseconds.");
        // HashMap
        before = Instant.now();
        for(int i = 0; i < 10000; i++){
            boolean search = hashMap.containsKey(i);
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        hashMapDelta += delta;
        System.out.println("Searching 10000 elements in the HashMap took: " + delta + " nanoseconds.");
    }

    public void deleteElements(){
        // LinkedList
        Instant before = Instant.now();
        for(int i = 0; i < 10000; i++) {
            linkedList.remove();
        }
        Instant after = Instant.now();
        long delta = Duration.between(before, after).toNanos();
        linkedListDelta += delta;
        System.out.println("Deleting 10000 elements from the LinkedList took: " + delta + " nanoseconds.");
        // Stack
        before = Instant.now();
        for(int i = 0; i < 10000; i++){
            stack.pop();
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        stackDelta += delta;
        System.out.println("Deleting 10000 elements in the Stack took: " + delta + " nanoseconds.");
        // Queue
        before = Instant.now();
        for(int i = 0; i < 10000; i++){
            priorityQueue.remove();
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        queueDelta += delta;
        System.out.println("Deleting 10000 elements in the Queue took: " + delta + " nanoseconds.");
        // HashMap
        before = Instant.now();
        for(int i = 0; i < 10000; i++){
            hashMap.remove(i);
        }
        after = Instant.now();
        delta = Duration.between(before,after).toNanos();
        hashMapDelta += delta;
        System.out.println("Deleting 10000 elements in the HashMap took: " + delta + " nanoseconds.");

    }

    public void printDeltas(){
        System.out.println("LinkedList Delta total: " + linkedListDelta);
        System.out.println("Stack Delta total: " + stackDelta);
        System.out.println("Queue Delta total: " + queueDelta);
        System.out.println("HashMap Delta total: " + hashMapDelta);
    }

    public DataStructureCreator() {
    }
}