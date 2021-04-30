package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 2:
 *
 *      Create an application that creates a Thread using the Thread class
 */

class Controller02{
    public static void main(String[] args) {
        Exercise_02 thread1 = new Exercise_02();
        thread1.setName("Thread1");
        thread1.start();
    }
}

class Exercise_02 extends Thread{
    @Override
    public void run() {
        System.out.println("Running thread: " + getName());
    }
}