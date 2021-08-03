package labs_examples.datastructures.trees.labs;

/**
 *
 *      Last thing to add is capability to tie a value with the key of each node
 *
 */

public class Exercise1Class {
    public static void main(String[] args) {


        CustomBinarySearchTree myTree = new CustomBinarySearchTree(3, 7, 5, 1, 8, 2, 7, 10);
        myTree.insert(11);
        System.out.println("My tree is balanced: " + myTree.isBalanced());
        int getting = myTree.get(4);
        System.out.println("I have retrieved the value: " + getting);
        boolean updating = myTree.update(1,12341);
        System.out.println("Updating value at the data of 1. Successful: " + updating);
        myTree.remove(1);
        myTree.printInOrder(myTree.root);
        System.out.println();
        myTree.printPreOrder(myTree.root);
        System.out.println();
        myTree.printPostOrder(myTree.root);
    }
}

class CustomBinarySearchTree{

    Node root;
    int size;

    public void printInOrder(Node node){
        if(node == null){
            return;
        }
        printInOrder(node.leftChild);
        System.out.print(node.data + " ");
        printInOrder(node.rightChild);
    }

    public void printPreOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        printInOrder(node.leftChild);
        printInOrder(node.rightChild);
    }

    public void printPostOrder(Node node){
        if(node == null){
            return;
        }
        printInOrder(node.leftChild);
        printInOrder(node.rightChild);
        System.out.print(node.data + " ");
    }

    public void insert(int data) {

        // if the tree is empty, create a new root node
        if (root == null) {
            root = new Node(data);
            size++;
        }
        // start the recursive insert() method, passing the data and the "root" node
        else {
            insert(data, root);
        }
    }

    private Node insert(int data, Node node) {

        // create new root node
        if (node == null) {
            node = new Node(data);
            size++;
        }

        // move to leftChild of tree
        if (data < node.data) {
            // recursive call - passing the left child Node (effectively traversing left)
            node.leftChild = insert(data, node.leftChild);
        }
        // move to rightChild of tree
        else if (data > node.data){
            // recursive call - passing the left child Node (effectively traversing left)
            node.rightChild = insert(data, node.rightChild);
        }
        // if data is not < or > node.data it must be equal to - we prevent duplicates (datas) which break the tree
        else {
            return node;
        }

        // once we find the proper node where we should insert the data, call rebalanceInsert() which will
        // continuously attempt to keep the Tree in balance
        return rebalanceInsert(node, data);
    }

    boolean update(int olddata, int newdata){
        return update(olddata, newdata, root);
    }

    boolean update(int olddata, int newdata, Node node){
        if(node != null){
            if(node.data == olddata){
                remove(node.data);
                insert(newdata);
                return true;
            } else if (olddata < node.data) {
                return update(olddata, newdata, node.leftChild);
            } else if (olddata > node.data) {
                return update(olddata, newdata, node.rightChild);
            }
        }
        return false;
    }

    int get(int data){
        return get(data, root);
    }

    int get(int data, Node node){
        if(node != null){
            if(node.data == data){
                return node.data;
            } else if (data < node.data) {
                return get(data, node.leftChild);
            } else if (data > node.data) {
                return get(data, node.rightChild);
            }
        }
        return 0;
    }

    private Node rebalanceInsert(Node node, int data) {

        // get heights of child nodes
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);

        // update height of node to the greatest of its child heights
        node.height = 1 + Math.max(leftHeight, rightHeight);

        // calculate balance factor of node
        int balanceFactor = leftHeight - rightHeight;

        // leftChild is bigger and new node is less than leftChild - we need to move the current node.leftChild so that
        // it will become node.rightChild and the new node that we're inserting will become node.leftChild
        if (balanceFactor > 1 && data < node.leftChild.data) {
            //
            return rotateRight(node);
        }
        // rightChild is bigger and new node is greater than rightChild - inverse of above section - need to move
        // current right child to left child because the node we're inserting is larger than right chuild
        if (balanceFactor < -1 && data > node.rightChild.data) {
            //
            return rotateLeft(node);
        }
        // leftChild is bigger and new node is greater than leftChild
        if (balanceFactor > 1 && data > node.leftChild.data) {
            // rotate leftChild first to get to simple case
            node.leftChild = rotateLeft(node.leftChild);
            // then do simple rotation
            return rotateRight(node);
        }
        // rightChild is bigger and new node is less than rightChild
        if (balanceFactor < -1 && data < node.rightChild.data) {
            // rotate rightChild first to get to simple case
            node.rightChild = rotateRight(node.rightChild);
            // then do simple rotation
            return rotateLeft(node);
        }

        return node;
    }

    private Node rotateRight(Node node) {
        // copy node's leftChild child (which will become the root node of this subtree)
        Node child = node.leftChild;
        // make a backup of right child (the right child is about to be overwritten)
        Node formerRightChild = child.rightChild;

        // rotate - set the new right child to the node we're inserting
        child.rightChild = node;
        // set the left child to what was formerly the right child
        node.leftChild = formerRightChild;

        // update heights
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        leftHeight = height(child.leftChild);
        rightHeight = height(child.rightChild);
        child.height = 1 + Math.max(leftHeight, rightHeight);

        node = child;
        return node;
    }

    private Node rotateLeft(Node node) {
        // copy node's right child (which will become the root node of this subtree)
        Node child = node.rightChild;
        // make a backup of left child (the left child is about to be overwritten)
        Node grandChild = child.leftChild;

        // rotate - set the new left child to the node we're inserting
        child.leftChild = node;
        // set the right child to what was formerly the left child
        node.rightChild = grandChild;

        // update heights
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        leftHeight = height(child.leftChild);
        rightHeight = height(child.rightChild);
        child.height = 1 + Math.max(leftHeight, rightHeight);

        node = child;
        return node;
    }

     boolean search(int target) {
        // call the search helper (recursive) method
        return search(target, root);
    }

    boolean search(int target, Node node) {
        // make sure end of branch hasn't been reached
        if (node != null) {
            if (node.data == target) {
                // target found - return true - it does exist
                return true;
            }
            // follow the leftChild branch
            else if (target < node.data) {
                return search(target, node.leftChild);
            }
            // follow the rightChild branch
            else if (target > node.data) {
                return search(target, node.rightChild);
            }
        }

        return false;
    }

    public void remove(int target) {

        // make sure node exists - if it doesn't
        if (!search(target)) {
            return;
        }

        // start the recursive helper method
        System.out.println("removing " + target);
        root = remove(target, root);
    }

    private Node remove(int target, Node node) {

        // move recursively leftChild
        if (target < node.data) {
            node.leftChild = remove(target, node.leftChild);
        }
        // move recursively rightChild
        else if (target > node.data){
            node.rightChild = remove(target, node.rightChild);
        }
        // currently at the target Node
        else {

            // currently at a leaf Node
            if (node.leftChild == null && node.rightChild == null) {
                // delete current Node
                size--;
                return null;
            }
            // no leftChild branch
            else if (node.leftChild == null) {
                // delete current Node and link to rightChild branch
                size--;
                return node.rightChild;
            }
            // no rightChild branch
            else if (node.rightChild == null) {
                // delete current Node and link to leftChild branch
                size--;
                return node.leftChild;
            }
            // two branches
            else {
                // get the smallest node that's bigger than leftChild node
                // swap its value to the current node position then remove the old node

                // start at the top of the rightChild branch
                Node smallest = node.rightChild;

                // iterate down the leftChild to the smallest node
                while (smallest.leftChild != null) {
                    smallest = smallest.leftChild;
                }

                // swap current data with smallest
                int temp = node.data;
                node.data = smallest.data;
                smallest.data = temp;

                // remove old smallest node
                node.rightChild = remove(target, node.rightChild);
            }

        }

        return rebalanceRemove(node);
    }

    private Node rebalanceRemove(Node node) {

        // update height
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        // calculate balance factor of node
        int balanceFactor = leftHeight - rightHeight;

        // calculate leftChild balance
        leftHeight = 0;
        rightHeight = 0;
        if (node.leftChild != null) {
            leftHeight = height(node.leftChild.leftChild);
            rightHeight = height(node.leftChild.rightChild);
        }
        int balanceLeft = leftHeight - rightHeight;

        // calculate rightChild balance
        leftHeight = 0;
        rightHeight = 0;
        if (node.rightChild != null) {
            leftHeight = height(node.rightChild.leftChild);
            rightHeight = height(node.rightChild.rightChild);
        }
        int balanceRight = leftHeight - rightHeight;

        // rebalance
        if (balanceFactor > 1 && balanceLeft >= 0) {
            return rotateRight(node);
        }
        if (balanceFactor > 1 && balanceLeft < 0) {
            node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        }
        if (balanceFactor < -1 && balanceRight <= 0) {
            node =  rotateLeft(node);
            return node;
        }
        if (balanceFactor < -1 && balanceRight > 0) {
            node.rightChild = rotateRight(node.rightChild);
            return rotateLeft(node);
        }

        return node;
    }

    private int height(Node node){
        if (node == null){
            return 0;
        }
        return node.height;
    }

    public boolean isBalanced(){
        int balanceFactor = height(root.leftChild) - height(root.rightChild);
        return Math.abs(balanceFactor) <= 1;
    }

    CustomBinarySearchTree(int ... data) {

        // if the user passes no data to insert, simply initialize an empty tree
        if (data.length < 1) {
            root = null;
        }

        // otherwise, initialize tree with given data
        else {
            for (int i = 0; i < data.length; i++) {
                // for each int data that the user passed in, call the insert() method and pass each int
                insert(data[i]);
            }
        }
    }

    private class Node {
        Node leftChild;
        Node rightChild;
        int data;

        int height;

        Node (int data) {
            this.data = data;
            this.height = 1;
        }
    }
}
