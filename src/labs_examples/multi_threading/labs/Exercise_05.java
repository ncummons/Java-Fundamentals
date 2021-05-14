package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 5:
 *
 *      Demonstrate the use of a wait() and notify()
 *
 *      Create sequence of threads, where second thread needs to wait until first thread has finished a specific
 *      task such as summing an array, concatenating inputs, etc.
 *
 *      NEED TO FIX NOTIFY() --> I cannot get it to work for me.
 *
 */

class ControlsThreads{

    public static void main(String[] args) {
        ArrayToSum myArray = new ArrayToSum();

        myArray.populateArray();
        myArray.printArray();

        // So far so good

        Summer summer = new Summer("Sum Thread", myArray);
        Printer printer = new Printer("Printer Thread", myArray);

    }

}

class ArrayToSum{

    Integer[] intArr = new Integer[10];
    boolean isSummed = false;
    int sumToPrint;
    boolean initialized = false;

    public void populateArray() {
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = i + 1;
        }
    }

    public void printArray(){
        System.out.print("| ");
        for (int x: intArr) {
            System.out.print(x + " | ");
        }
        System.out.println();
    }

}

class Summer implements Runnable{

    Thread thread;
    ArrayToSum arrayToSum;


    public Summer(String name, ArrayToSum arr) {
        thread = new Thread(this, name);
        arrayToSum = arr;
        thread.start();
    }

    @Override
    public void run() {
        int sum = 0;
        synchronized (arrayToSum) {
            if(!arrayToSum.initialized){
                System.out.println(thread.getName() + " is waiting.");
                try {
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            while (!arrayToSum.isSummed) {
                for (int x : arrayToSum.intArr) {
                    try {
                        thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sum += x;
                    System.out.println("The current sum is: " + sum);
                }
                arrayToSum.sumToPrint = sum;
                arrayToSum.isSummed = true;
                }
            }
        try{
            notify();
        }catch (IllegalMonitorStateException e){
            e.printStackTrace();
        }
    }
}

class Printer implements Runnable{

    Thread thread;
    ArrayToSum arrayToSum;

    public Printer(String name, ArrayToSum arr) {
        thread = new Thread(this, name);
        arrayToSum = arr;
        thread.start();
    }

    @Override
    public void run() {
        synchronized (arrayToSum){
            if (!arrayToSum.initialized){
                System.out.println("Initializing thread " + thread.getName());
                arrayToSum.initialized = true;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (!arrayToSum.isSummed){
                try {
                    System.out.println("Not yet summed.");
                    wait();
                } catch (InterruptedException e)  {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread interrupted " + e);
                }
            }
            if (arrayToSum.isSummed){
                System.out.println("The total sum of the array is: " + arrayToSum.sumToPrint);
            }
        }
    }
}