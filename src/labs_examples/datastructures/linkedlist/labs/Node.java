package labs_examples.datastructures.linkedlist.labs;

public class Node<T> {

    T data;

    Node next;
    Node prev;

    public Node(T data, Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data, Node prev, boolean setPrevNode) {
        if(setPrevNode) {
            this.data = data;
            this.prev = prev;
        }
    }

    public Node(T data) {
        this.data = data;
    }

    public Node() {
    }

    public boolean hasNext(){
        return next != null;
    }

    public boolean hasPrev(){
        return prev != null;
    }
}
