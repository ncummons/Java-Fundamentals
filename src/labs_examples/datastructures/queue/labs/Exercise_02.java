package labs_examples.datastructures.queue.labs;


/**
 *      Queues - Exercise_02
 *
 *      Write a new custom (Generic) Queue class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Queue class must also do the following:
 *
 *          1) throw a custom exception when trying to pop  an element from an empty Queue
 *          2) resize the Queue (the underlying array) to be twice the size when the Queue is more than 3/4 full
 *          3) resize the Queue (the underlying array) to be half the size when the Queue is more than 1/4 empty
 *          4) contain the methods peekFirst() and peekLast()
 *          5) contain a size() method
 *          6) contain a method to print out the data of all elements in the Queue
 *
 */

class CustomQueueController{
    public static void main(String[] args) {
        CustomQueueClass<String> myQ = new CustomQueueClass<>();
        myQ.push("One");
        myQ.push("Two");
        System.out.println(myQ.queueSize());
        myQ.push("Three");
        myQ.push("Four");
        myQ.push("Five");
        myQ.push("Six");
        myQ.push("Seven");
        myQ.push("Eight");
        myQ.push("Nine");
        myQ.printAll();
        System.out.println(myQ.peekFirst());
        System.out.println(myQ.peekLast());
        System.out.println(myQ.pop());
        System.out.println(myQ.pop());
        System.out.println(myQ.pop());
        System.out.println(myQ.pop());
        System.out.println(myQ.pop());
        System.out.println(myQ.pop());
        System.out.println(myQ.pop());
        System.out.println(myQ.pop());
        System.out.println(myQ.pop());
        System.out.println(myQ.pop());
    }
}

class CustomQueueClass<T>{
    private Object[] data;
    private int size;

    public T pop(){
        try {
            if(queueSize() == 0){
                throw new CustomEmptyQueueException();
            }
            T item = null;
            int counter = 0;
            for(Object element: data){
                if(element != null){
                    item = (T) element;
                    counter++;
                }
            }
            data[counter-1] = null;
            if(queueSize() < (this.size * .25)){
                this.size /= 2;
                Object[] tempArr = (T[]) new Object[size];
                for(int i = 0; i < tempArr.length; i++){
                    tempArr[i] = data[i];
                }
                data = tempArr;
            }
            return item;
        } catch (CustomEmptyQueueException e){
            e.printStackTrace();
            return null;
        }
    }

    public void push(T item){
        try {
            if (queueSize() < size) {
                for (int i = data.length-1; i > 0; i--) {
                    data[i] = data[i - 1];
                }
                data[0] = item;
            } else if (data.length >= size) {
                throw new CustomFullQueueException();
            }
            if(queueSize() > (size * .75)){
                size *= 2;
                Object[] tempArr = (T[]) new Object[size];
                for(int i = 0; i < data.length; i++){
                    tempArr[i] = data[i];
                }
                data = tempArr;
            }
        } catch (CustomFullQueueException e){
            e.printStackTrace();
        }
    }

    public T peekFirst(){
        try {
            T item = (T) data[0];
            return item;
        } catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    public T peekLast(){
        try {
            T item = (T) data[queueSize() - 1];
            return item;
        } catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    public int queueSize(){
        int counter = 0;
        for (Object element : data) {
            if(element != null){
                counter++;
            }
        }
        return counter;
    }

    public void printAll(){
        for(Object element: data){
            if(element != null) {
                System.out.print("{" + element + "}, ");
            }
        }
        System.out.println();
    }

    public CustomQueueClass() {
        data = new Object[10];
        size = 10;
    }

    public CustomQueueClass(Object[] data) {
        this.data = data;
        this.size = data.length;
    }
}

class CustomEmptyQueueException extends RuntimeException{
}

class CustomFullQueueException extends RuntimeException{
}