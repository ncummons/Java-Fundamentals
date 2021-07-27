package labs_examples.datastructures.queue.labs;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 *      Demonstrate your mastery of Java's (sun's) built-in Queue class (as seen in the import statement
 *      above) by completing the following:
 *
 *      1) instantiate a new Queue
 *      2) demonstrate the use of EVERY method in the Queue class - there are 7
 *          Add, offer, remove, poll, element, peek, and contains
 */

class JavaQueuePractice{
    public static void main(String[] args) {
        PriorityQueue<Integer> practiceQueue = new PriorityQueue<>();
        for(int i = 0; i < 11; i++) {
            practiceQueue.add(i);
        }
        boolean canAdd = practiceQueue.offer(11);
        System.out.println("11 can be added: " + canAdd);
        System.out.println("11 was removed: " + practiceQueue.remove("11"));
        while(practiceQueue.peek() != null){
            practiceQueue.poll();
        }
        try {
            int myInt = practiceQueue.remove();
            System.out.println(myInt);
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
        System.out.println("The queue contains 12: " + practiceQueue.contains(12));
        practiceQueue.add(12);
        System.out.println("The first element is: " + practiceQueue.element());
        System.out.println("The queue contains 12: " + practiceQueue.contains(12));
    }
}