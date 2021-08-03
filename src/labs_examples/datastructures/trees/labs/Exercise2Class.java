package labs_examples.datastructures.trees.labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
    Trees: Exercise_02

    For this challenge, please research and implement a custom Trie data structure (https://en.wikipedia.org/wiki/Trie).

    Trie's are very interesting and useful data structures. Many interview questions, and real-world scenario's
    can be properly addressed using a Trie. We use Tries to store things like words and numbers in a highly
    efficient manner. See here: http://theoryofprogramming.com/wp-content/uploads/2015/06/trie12.jpg

    Understanding and implement a Trie is a fantastic step in thinking creatively as a developer to
    accomplish goals as efficiently as possible.

    Here is a fantastic set of relevant interview questions: https://www.techiedelight.com/trie-interview-questions/

    I am following the techie delight tutorial to build and implement a trie

 */


public class Exercise2Class {
    public static void main(String[] args) {
        // construct a new Trie node
        Trie head = new Trie();

        head.insert("techie");
        head.insert("techi");
        head.insert("tech");

        System.out.println(head.search("tec"));
        System.out.println(head.search("tech"));
        System.out.println(head.search("techi"));
        System.out.println(head.search("techie"));
        System.out.println(head.search("techiedelight"));

        head.insert("techiedelight");

        System.out.println(head.search("tech"));
        System.out.println(head.search("techi"));
        System.out.println(head.search("techie"));
        System.out.println(head.search("techiedelight"));
    }
}

// A class to store a Trie node
class Trie {

    // Define the alphabet size (26 characters for `a-z`)
    private static final int CHAR_SIZE = 26;

    private boolean isLeaf;
    private List<Trie> children = null;

    // Constructor
    Trie(){
        isLeaf = false;
        children = new ArrayList<>(Collections.nCopies(CHAR_SIZE,null));
    }

    // Iterative function to insert a string into a Trie
    public void insert(String key){
        System.out.println("Inserting \"" + key + "\"");

        // start from the root node
        Trie curr = this;

        // do for each character of the key
        for (char c: key.toCharArray()){
            // create a new Trie node if the path does not exist
            if (curr.children.get(c - 'a') == null){
                curr.children.set(c - 'a', new Trie());
            }

            // go to the next node
            curr = curr.children.get(c - 'a');
        }
        // mark the current node as a leaf
        curr.isLeaf = true;
    }

    // Iterative function to search a key in a Trie. It returns true if the key
    // is found in the Trie; otherwise, it returns false
    public boolean search(String key){
        System.out.println("Searching \"" + key + "\" : ");

        Trie curr = this;

        // do for each character of the key
        for (char c: key.toCharArray()){

            // go to the next node
            curr = curr.children.get(c - 'a');

            // if the string is invalid (reached the end of a path in the Trie)
            if (curr == null){
                return false;
            }
        }

        // return true if the current node is a leaf node and the end of the string is reached
        return curr.isLeaf;

    }

}
