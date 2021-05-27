package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 6:
 *
 *      Write a program that will print 1-100 sequentially from at least two distinct threads. For instance, thread1 will
 *      print "1", then thread2 will print "2", then thread1 will print "3", then thread2 will print "4" and so on.
 */

class ControllerClass6{

    public static void main(String[] args) {
        Counter myCounter = new Counter();
        Thread evenThread = new Thread(new Evens(myCounter));
        Thread oddThread = new Thread(new Odds(myCounter));
        evenThread.start();
        oddThread.start();
    }


}

class Odds implements Runnable{

    Counter counter;

    public Odds(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.countOdds();
    }
}

class Evens implements Runnable{

    Counter counter;

    public Evens(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.countEvens();
    }
}

class Counter{
    boolean isOdd = false;
    int count = 0;

    public synchronized void countEvens() {
        while (count < 99) {
            while (!isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println("The current count is: " + count + ", which is an even number.");
            if ((count % 2) == 0) {
                isOdd = false;
            } else {
                isOdd = true;
            }
            notifyAll();
        }
    }

    public synchronized void countOdds() {
        while (count < 99) {
            while (isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println("The current count is: " + count + ", which is an odd number.");
            if ((count % 2) == 0) {
                isOdd = false;
            } else {
                isOdd = true;
            }
            notifyAll();
        }
    }

}