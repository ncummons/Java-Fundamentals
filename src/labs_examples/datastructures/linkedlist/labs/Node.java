package labs_examples.datastructures.linkedlist.labs;

public class Node<T> {

    T data;

    Node next;

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this.data = data;
    }

    public Node() {
    }
}
