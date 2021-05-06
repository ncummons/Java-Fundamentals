package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 4:
 *
 *      Demonstrate the use of a synchronized block and a synchronized method - ensure that the synchronization is
 *      working as expected
 *
 *      set two threads to count to 1000 and then have them output at the end of their thread the final count, but
 *      have the sum not reset between threads, so it would end at 2000 after the second, 3000 after the third, etc.
 *
 */

class ControllerClass{

    public static void main(String[] args) {
        CounterClass counter = new CounterClass();
        Exercise04 thread1 = new Exercise04("Thread1", counter);
        Exercise04 thread2 = new Exercise04("Thread2", counter);
        Exercise04 thread3 = new Exercise04("Thread3", counter);
        Exercise04 thread4 = new Exercise04("Thread4", counter);

        System.out.println("Main method done already, but the threads cannot all complete at once.");

    }

}

class CounterClass{
    private int sumCount = 0;

    public void add1000ToCount(){
        synchronized (this){
            for(int i = 0; i < 1000; i++){
                sumCount++;
            }
        }
    }

    public int getSumCount() {
        return sumCount;
    }
}

class Exercise04 implements Runnable{

    Thread thread;
    CounterClass counter;

    @Override
    public void run() {
        counter.add1000ToCount();
        synchronized (counter) {
            System.out.println("The count is: " + counter.getSumCount() + ". Now in " + thread.getName());
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Exercise04(String name, CounterClass counter) {
        this.counter = counter;
        thread = new Thread(this, name);
        thread.start();
    }
}