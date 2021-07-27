package labs_examples.datastructures.stack.labs;

/**
 *      Stacks - Exercise_02
 *
 *      Write a new custom (Generic) Stack class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Stack class must also do the following: (Ryan Take 2)
 *
 *          1) throw a custom exception when trying to pop an element from an empty Stack
 *          2) resize the Stack (the underlying array) to be twice the size when the Stack is more than 3/4 full
 *          3) resize the Stack (the underlying array) to be half the size when the Stack is more than 1/4 empty
 *          4) contain the methods peekFirst() and peekLast()
 *          5) contain a size() method
 *          6) contain a method to print out the data of all elements in the Stack
 *
 *      TIP: To initialize an new array of a Generic type you can use this:
 *           Object[] data = (T[]) new Object[10];
 */
class MyStackController{
    public static void main(String[] args) {
        MyStackPractice<Integer> myStack = new MyStackPractice<>();
        for(int i = 1; i < 13; i++){
            myStack.push(i);
        }
        int myInt = myStack.peekFirst();
        System.out.println("First element: " + myInt);
        myInt = myStack.pop();
        System.out.println("Element popped: " + myInt);
        myStack.push(100);
        myInt = myStack.peekLast();
        System.out.println("Last element: " + myInt);
        myInt = myStack.stackSize();
        System.out.println("The stack has: " + myInt + " elements.");
        myStack.printAll();

        String[] stringArr = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven"};

        MyStackPractice<String> myNewStack = new MyStackPractice<>(stringArr);
        myNewStack.printAll();
        for(int i = 0; i < 12; i++){
            System.out.print("Popping element: " + myNewStack.pop() + " | ");
            System.out.println("New stack size: " + myNewStack.stackSize());
        }
    }
}


class MyStackPractice<T>{

    private Object[] data;
    private int size;


    public void push(T item){
        try {
            if(stackSize() > (size * .75)){
                size *= 2;
                Object[] tempArr = (T[]) new Object[size];
                for(int i = 0; i < data.length; i++){
                    tempArr[i] = data[i];
                }
                data = tempArr;
            }
            if (stackSize() < size) {
                for (int i = data.length-1; i > 0; i--) {
                    data[i] = data[i - 1];
                }
                data[0] = item;
            } else if (data.length >= size) {
                throw new CustomFullStackException();
            }
        } catch (CustomFullStackException e){
            e.printStackTrace();
        }
    }

    public T pop(){
        try {
            if(stackSize() == 0){
                throw new CustomEmptyStackException();
            }
            T item = (T) data[0];
            if (data[data.length-1] != null) {
                for (int i = 1; i < data.length; i++) {
                    data[i - 1] = data[i];
                }
                data[data.length-1] = null;
            } else {
                for (int i = 1; i < data.length; i++) {
                    data[i - 1] = data[i];
                }
            }
            if(stackSize() < (this.size * .25)){
                this.size /= 2;
                Object[] tempArr = (T[]) new Object[size];
                for(int i = 0; i < tempArr.length; i++){
                    tempArr[i] = data[i];
                }
                data = tempArr;
            }
            return item;
        } catch (CustomEmptyStackException e){
            e.printStackTrace();
            return null;
        }
    }
    public T peekFirst(){
        try{
            if(stackSize() == 0){
                throw new CustomEmptyStackException();
            }
            T item = (T) data[0];
            return item;
        } catch (CustomEmptyStackException e){
            e.printStackTrace();
            return null;
        }
    }

    public T peekLast(){
        try{
            if(stackSize() == 0){
                throw new CustomEmptyStackException();
            }
            T item = (T) data[stackSize()-1];
            return item;
        } catch (CustomEmptyStackException e){
            e.printStackTrace();
            return null;
        }
    }

    public int stackSize(){
        int counter = 0;
        for (Object element: data) {
            if (element != null) {
                counter++;
            }
        }
        return counter;
    }

    public void printAll(){
        try{
            if(data.length == 0){
                throw new CustomEmptyStackException();
            }
            int counter = 0;
            for(int i = 0; i < data.length; i++){
                if(counter % 10 == 0){
                    System.out.println();
                }
                if(data[i] != null) {
                    System.out.print("{" + data[i] + "}, ");
                }
                counter++;
            }
            System.out.println();
        } catch (CustomEmptyStackException e){
            e.printStackTrace();
        }
    }

    public MyStackPractice(){
        data = (T[]) new Object[10];
        this.size = 10;
    }

    public MyStackPractice(T[] arr){
        this.data = arr;
        this.size = arr.length;
    }
}

class CustomFullStackException extends RuntimeException{
    public CustomFullStackException() {
    }
}
class CustomEmptyStackException extends RuntimeException{
    public CustomEmptyStackException(){

    }
}