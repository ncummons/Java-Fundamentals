package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 1:
 *
 *      1: Create an application that starts a Thread by implementing the Runnable interface
 *      2: Demonstrate at least two distinct ways of initiating a Thread using the Runnable you just created
 *
 *      *3*: CHANGING PRIORITY FOR THREAD1 IN THE CONSTRUCTOR, AS PARAMETER AND THREAD2 AS A SIMPLE COMMAND
 *
 *
 */
class Controller1{

    public static void main(String[] args) {

        // Using the constructor solely to create and start
        Exercise_01 thread1 = new Exercise_01("Thread1", 1);

        // Going step by step, using the thread constructor to pass in the target and name
        Exercise_01 thread2 = new Exercise_01();
        Thread t = new Thread(thread2,"Thread2");
        thread2.setThread(t);
        thread2.thread.setPriority(Thread.MAX_PRIORITY);
        thread2.thread.start();
    }



}

class Exercise_01 implements Runnable{

    Thread thread;

    @Override
    public void run() {
        System.out.println("Running " + thread.getName());
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Exercise_01(String name, int priority) {
        thread = new Thread(this, name);
        thread.setPriority(priority);
        thread.start();
    }

    public Exercise_01() {
    }

}