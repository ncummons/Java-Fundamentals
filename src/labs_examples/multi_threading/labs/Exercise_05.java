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
 *      Look at the Coding Nomads example for ticked/tocked to understand wait and notify in ex. 10
 *      Edit: Fixed problem. Finally got it to do what I wanted.
 *
 */

class ControllerClass5{
    public static void main(String[] args) {
        ArrayToSum myArr = new ArrayToSum();
        myArr.populateArray();
        myArr.printArray();
        ArrayManipulator arrayManipulator = new ArrayManipulator(myArr);
        Thread summer = new Thread(new Summer(arrayManipulator));
        Thread printer = new Thread(new PrintsSum(arrayManipulator));

        summer.start();
        printer.start();
    }
}

class Summer implements Runnable{

    ArrayManipulator summer;

    public Summer(ArrayManipulator summer) {
        this.summer = summer;
    }

    @Override
    public void run() {
        summer.sumArr();
    }
}

class PrintsSum implements Runnable{

    ArrayManipulator printsSum;

    public PrintsSum(ArrayManipulator printsSum) {
        this.printsSum = printsSum;
    }

    @Override
    public void run() {
        printsSum.printSum();
    }
}


class ArrayToSum {

    Integer[] intArr = new Integer[10];
    boolean isSummed = false;
    int sumToPrint;

    public void populateArray() {
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = i + 1;
        }
    }

    public void printArray() {
        System.out.print("| ");
        for (int x : intArr) {
            System.out.print(x + " | ");
        }
        System.out.println();
    }
}

class ArrayManipulator {

    ArrayToSum arrayToSum;

    public ArrayManipulator(ArrayToSum arr) {
        arrayToSum = arr;
    }

    public synchronized void sumArr() {
        int sum = 0;
        while (arrayToSum.isSummed){
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted" + e);
            }
        }
        for (int x : arrayToSum.intArr) {
            sum += x;
            System.out.println("The current sum is: " + sum);
        }
        arrayToSum.sumToPrint = sum;
        arrayToSum.isSummed = true;
        notifyAll();
    }

    public synchronized void printSum() {
        while(!arrayToSum.isSummed){
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted" + e);
            }
        }
        System.out.println("The final sum is: " + arrayToSum.sumToPrint);
    }
}


// Failed first attempt below -- I think I messed up on the scope of the array object perhaps in addition to some other things.
/* class ControlsThreads{

    public static void main(String[] args) {
        ArrayToSum myArray = new ArrayToSum();

        myArray.populateArray();
        myArray.printArray();

        // So far so good

        Summer summer = new Summer("Sum Thread", myArray);
        Printer printer = new Printer("Printer Thread", myArray);

        try {
            summer.thread.join();
            printer.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


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
            while(!arrayToSum.initialized){
                try {
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            if (arrayToSum.initialized) {
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
            if (arrayToSum.isSummed){
                try{
                    notify();
                }catch (IllegalMonitorStateException e){
                    e.printStackTrace();
                }
                return;
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
            while (!arrayToSum.initialized){
                System.out.println("Initializing thread " + thread.getName());
                arrayToSum.initialized = true;
                notify();
            }
            if (!arrayToSum.isSummed){
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
} */