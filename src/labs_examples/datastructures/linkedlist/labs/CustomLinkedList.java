package labs_examples.datastructures.linkedlist.labs;

public class CustomLinkedList<T> {

    private Node head;

    public CustomLinkedList(T...data){
        if(data.length < 1){
            head = null;
        } else {
            for(int i = 0; i < data.length; i++){
                add(data[i]);
            }
        }
    }
    public void add(T data){
        insert(data, size());
    }

    public void insert(T data, int index){
        if (head == null){
            head = new Node(data);
        } else {
            Node iterator = head;
            Node previous = null;

            if (index == 0) {
                head = new Node(data, head);
            } else if(index < size()){
                int count = 0;

                while(count != index) {
                    previous = iterator;
                    iterator = iterator.next;
                    count++;
                }
                previous.next = new Node(data, iterator);
            } else {
                while (iterator.next != null){
                    iterator = iterator.next;
                }
                iterator.next = new Node(data);
            }
        }
    }

    public int size() {
        int count = 0;
        Node iterator = head;
        while(iterator != null){
            count++;
            iterator = iterator.next;
        }
        return count;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else if (index < size()) {
            try {
                int count = 0;
                Node previous = null;
                Node iterator = head;

                while (count != index) {
                    previous = iterator;
                    iterator = iterator.next;
                    count++;
                }
                previous.next = iterator.next;

            } catch (NullPointerException ex) {
                System.out.println("Invalid index.");
            }
        } else {
            Node iterator = head;
            while(iterator.next != null){
                iterator = iterator.next;
            }
            iterator.next = null;
        }
    }

    public T get(int index){
        try{
            int count = 0;
            Node iterator = head;
            while(count != index){
                iterator = iterator.next;
                count++;
            }
            return (T) iterator.data;
        } catch (NullPointerException e){
            return null;
        }
    }

    public void set(int index, T data){
        try {
            int count = 0;
            Node iterator = head;

            while(count != index){
                iterator = iterator.next;
                count++;
            }
            iterator.data = data;
        } catch (NullPointerException e){
            System.out.println("Invalid index");
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public T pop(){
        // Removes and returns the first value in the list

        try{
            Node retNode = head.next;
            head = head.next;
            return (T) retNode.data;
        } catch (NullPointerException e){
            return null;
        }
    }

    public void addAll(T[] dataArr){
        if(dataArr.length > 0) {
            for (T element : dataArr) {
                add(element);
            }
        } else {
            System.out.println("Array is empty. Nothing added to LinkedList.");
        }
    }
}
