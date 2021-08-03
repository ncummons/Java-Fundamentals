package labs_examples.datastructures.trees.labs;

/**
 *
 *      Last thing to add is capability to tie a value with the key of each node
 *
 */

public class CopyExercise1Class {
    public static void main(String[] args) {
    }
}

class CustomBinarySearchTreeValue {

    Node root;
    int size;

    public void printInOrderCopy(Node node){
        if(node == null){
            return;
        }
        printInOrderCopy(node.leftChild);
        System.out.print(node.key + " ");
        printInOrderCopy(node.rightChild);
    }

    public void printPreOrderCopy(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.key + " ");
        printInOrderCopy(node.leftChild);
        printInOrderCopy(node.rightChild);
    }

    public void printPostOrderCopy(Node node){
        if(node == null){
            return;
        }
        printInOrderCopy(node.leftChild);
        printInOrderCopy(node.rightChild);
        System.out.print(node.key + " ");
    }

    public void insertCopy(int key, int value) {

        // if the tree is empty, create a new root node
        if (root == null) {
            root = new Node(key, value);
            size++;
        }
        // start the recursive insert() method, passing the data and the "root" node
        else {
            insertCopy(key, value, root);
        }
    }

    private Node insertCopy(int key, int value, Node node) {

        // create new root node
        if (node == null) {
            node = new Node(key, value);
            size++;
        }

        // move to leftChild of tree
        if (key < node.key) {
            // recursive call - passing the left child Node (effectively traversing left)
            node.leftChild = insertCopy(key, value, node.leftChild);
        }
        // move to rightChild of tree
        else if (key > node.key){
            // recursive call - passing the right child Node (effectively traversing right)
            node.rightChild = insertCopy(key, value, node.rightChild);
        }
        // if data is not < or > node.data it must be equal to - we prevent duplicates (datas) which break the tree
        else {
            return node;
        }

        // once we find the proper node where we should insert the data, call rebalanceInsert() which will
        // continuously attempt to keep the Tree in balance
        return rebalanceInsertCopy(node, key);
    }

    boolean updateCopy(int key, int value){
        return updateCopy(key, value, root);
    }

    boolean updateCopy(int key, int value, Node node){
        if(node != null){
            if(node.key == key){
                int temp = node.key;
                removeCopy(node.key);
                insertCopy(temp, value);
                return true;
            } else if (key < node.key) {
                return updateCopy(key, value, node.leftChild);
            } else if (key > node.key) {
                return updateCopy(key, value, node.rightChild);
            }
        }
        return false;
    }

    int getCopy(int key){
        return getCopy(key, root);
    }

    int getCopy(int key, Node node){
        if(node != null){
            if(node.key == key){
                return node.key;
            } else if (key < node.key) {
                return getCopy(key, node.leftChild);
            } else if (key > node.key) {
                return getCopy(key, node.rightChild);
            }
        }
        return 0;
    }

    private Node rebalanceInsertCopy(Node node, int data) {

        // get heights of child nodes
        int leftHeight = heightCopy(node.leftChild);
        int rightHeight = heightCopy(node.rightChild);

        // update height of node to the greatest of its child heights
        node.height = 1 + Math.max(leftHeight, rightHeight);

        // calculate balance factor of node
        int balanceFactor = leftHeight - rightHeight;

        // leftChild is bigger and new node is less than leftChild - we need to move the current node.leftChild so that
        // it will become node.rightChild and the new node that we're inserting will become node.leftChild
        if (balanceFactor > 1 && data < node.leftChild.key) {
            //
            return rotateRightCopy(node);
        }
        // rightChild is bigger and new node is greater than rightChild - inverse of above section - need to move
        // current right child to left child because the node we're inserting is larger than right chuild
        if (balanceFactor < -1 && data > node.rightChild.key) {
            //
            return rotateLeftCopy(node);
        }
        // leftChild is bigger and new node is greater than leftChild
        if (balanceFactor > 1 && data > node.leftChild.key) {
            // rotate leftChild first to get to simple case
            node.leftChild = rotateLeftCopy(node.leftChild);
            // then do simple rotation
            return rotateRightCopy(node);
        }
        // rightChild is bigger and new node is less than rightChild
        if (balanceFactor < -1 && data < node.rightChild.key) {
            // rotate rightChild first to get to simple case
            node.rightChild = rotateRightCopy(node.rightChild);
            // then do simple rotation
            return rotateLeftCopy(node);
        }

        return node;
    }

    private Node rotateRightCopy(Node node) {
        // copy node's leftChild child (which will become the root node of this subtree)
        Node child = node.leftChild;
        // make a backup of right child (the right child is about to be overwritten)
        Node formerRightChild = child.rightChild;

        // rotate - set the new right child to the node we're inserting
        child.rightChild = node;
        // set the left child to what was formerly the right child
        node.leftChild = formerRightChild;

        // update heights
        int leftHeight = heightCopy(node.leftChild);
        int rightHeight = heightCopy(node.rightChild);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        leftHeight = heightCopy(child.leftChild);
        rightHeight = heightCopy(child.rightChild);
        child.height = 1 + Math.max(leftHeight, rightHeight);

        node = child;
        return node;
    }

    private Node rotateLeftCopy(Node node) {
        // copy node's right child (which will become the root node of this subtree)
        Node child = node.rightChild;
        // make a backup of left child (the left child is about to be overwritten)
        Node grandChild = child.leftChild;

        // rotate - set the new left child to the node we're inserting
        child.leftChild = node;
        // set the right child to what was formerly the left child
        node.rightChild = grandChild;

        // update heights
        int leftHeight = heightCopy(node.leftChild);
        int rightHeight = heightCopy(node.rightChild);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        leftHeight = heightCopy(child.leftChild);
        rightHeight = heightCopy(child.rightChild);
        child.height = 1 + Math.max(leftHeight, rightHeight);

        node = child;
        return node;
    }

     boolean searchCopy(int target) {
        // call the search helper (recursive) method
        return searchCopy(target, root);
    }

    boolean searchCopy(int target, Node node) {
        // make sure end of branch hasn't been reached
        if (node != null) {
            if (node.key == target) {
                // target found - return true - it does exist
                return true;
            }
            // follow the leftChild branch
            else if (target < node.key) {
                return searchCopy(target, node.leftChild);
            }
            // follow the rightChild branch
            else if (target > node.key) {
                return searchCopy(target, node.rightChild);
            }
        }

        return false;
    }

    public void removeCopy(int target) {

        // make sure node exists - if it doesn't
        if (!searchCopy(target)) {
            return;
        }

        // start the recursive helper method
        System.out.println("removing " + target);
        root = removeCopy(target, root);
    }

    private Node removeCopy(int target, Node node) {

        // move recursively leftChild
        if (target < node.key) {
            node.leftChild = removeCopy(target, node.leftChild);
        }
        // move recursively rightChild
        else if (target > node.key){
            node.rightChild = removeCopy(target, node.rightChild);
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
                int temp = node.key;
                node.key = smallest.key;
                smallest.key = temp;

                // remove old smallest node
                node.rightChild = removeCopy(target, node.rightChild);
            }

        }

        return rebalanceRemoveCopy(node);
    }

    private Node rebalanceRemoveCopy(Node node) {

        // update height
        int leftHeight = heightCopy(node.leftChild);
        int rightHeight = heightCopy(node.rightChild);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        // calculate balance factor of node
        int balanceFactor = leftHeight - rightHeight;

        // calculate leftChild balance
        leftHeight = 0;
        rightHeight = 0;
        if (node.leftChild != null) {
            leftHeight = heightCopy(node.leftChild.leftChild);
            rightHeight = heightCopy(node.leftChild.rightChild);
        }
        int balanceLeft = leftHeight - rightHeight;

        // calculate rightChild balance
        leftHeight = 0;
        rightHeight = 0;
        if (node.rightChild != null) {
            leftHeight = heightCopy(node.rightChild.leftChild);
            rightHeight = heightCopy(node.rightChild.rightChild);
        }
        int balanceRight = leftHeight - rightHeight;

        // rebalance
        if (balanceFactor > 1 && balanceLeft >= 0) {
            return rotateRightCopy(node);
        }
        if (balanceFactor > 1 && balanceLeft < 0) {
            node.leftChild = rotateLeftCopy(node.leftChild);
            return rotateRightCopy(node);
        }
        if (balanceFactor < -1 && balanceRight <= 0) {
            node =  rotateLeftCopy(node);
            return node;
        }
        if (balanceFactor < -1 && balanceRight > 0) {
            node.rightChild = rotateRightCopy(node.rightChild);
            return rotateLeftCopy(node);
        }

        return node;
    }

    private int heightCopy(Node node){
        if (node == null){
            return 0;
        }
        return node.height;
    }

    public boolean isBalanced(){
        int balanceFactor = heightCopy(root.leftChild) - heightCopy(root.rightChild);
        return Math.abs(balanceFactor) <= 1;
    }

    CustomBinarySearchTreeValue(int ... values) {

        // if the user passes no data to insert, simply initialize an empty tree
        if (values.length < 1) {
            root = null;
        }

        // otherwise, initialize tree with given data
        else {
            for (int i = 0; i < values.length; i++) {
                // for each int data that the user passed in, call the insert() method and pass each int
                insertCopy(i, values[i]);
            }
        }
    }

    private class Node {
        Node leftChild;
        Node rightChild;
        int key;
        int value;

        int height;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }
}
