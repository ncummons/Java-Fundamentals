package labs_examples.datastructures.hashmap.labs;

import java.util.LinkedList;
import java.util.Map;

/**
 *      HashMaps Exercise_02
 *
 *      Rewrite the CustomHashMap class to meet the following requirements:
 *          1) no method has the same name as any in CustomHashMap
 *              (do not use refactor - do it manually)
 *          2) no variable has the same name as any in CustomHashMap
 *              (do not use refactor - do it manually)
 *          3) resize the HashMap when the underlying array is more than half full
 *          4) triple the size of the underlying array on resize()
 *          5) instead of checking the number of keys to resize, check the number of values
 *          6) on collisions, add new elements to the front of the LinkedList, not the end
 *          7) anytime someone tries to get/update/remove an element that does not exist, print
 *              out a message indicating that the element does not exist
 *          8) add at least one more method that you think could be useful to the HashMap
 *              review Java's built-in HashMap for inspiration
 *              -- added isEmpty() and size()
 */

class CustomHashMap<K,V> {
    private Entry<K,V>[] theMap = new Entry[10];

    private int slash(K key){
        int numba = Math.abs(key.hashCode() % theMap.length);
        return numba;
    }

    public void place(K key, V value){
        int numba = slash(key);
        Entry<K, V> thisOne = new Entry<>(key, value);

        if (theMap[numba] == null){
            theMap[numba] = thisOne;
        } else{
            Entry<K,V> node = theMap[numba];
            theMap[numba] = thisOne;
            theMap[numba].next = node;
            /** while(node.next != null){
            //    node = node.next;
            // }
            // node.next = thisOne; */
        }
        if (size() > theMap.length * .5){
            makeBigger();
        }
    }

    private void makeBigger(){
        Entry<K,V>[] obsolete = theMap;
        theMap = new Entry[obsolete.length * 3];

        for(int i = 0; i <obsolete.length; i++){
            try{
                Entry thisOne = obsolete[i];
                place((K) thisOne.getKey(), (V) thisOne.getValue());

                while (thisOne.next != null) {
                    thisOne = thisOne.next;
                    place((K) thisOne.getKey(), (V) thisOne.getValue());
                }
            } catch (Exception e) {
            }
        }
    }

    public V fetch(K key){
        int numba = slash(key);

        if(theMap[numba] == null){
            return null;
        }
        Entry<K, V> thisOne = theMap[numba];

        while(thisOne.getKey() != key){
            if(thisOne.next == null){
                System.out.println("Error, key does not exist.");
                return null;
            }
            thisOne = thisOne.next;
        }
        return thisOne.getValue();
    }

    public void rip(K key){
        if (fetch(key) == null){
            return;
        }
        int numba = slash(key);
        Entry<K,V> thisOne = theMap[numba];

        if(thisOne.getKey().equals(key)){
            theMap[numba] = null;
        }
        while(thisOne.next != null) {
            if(thisOne.next.getKey() != key){
                thisOne = thisOne.next;
            }
        }
        if(thisOne.next.next != null){
            thisOne.next = thisOne.next.next;
        }
        else{
            thisOne.next = null;
        }
    }

    public LinkedList<V> makeMyValuesIntoALinkedList(){
        LinkedList<V> vals = new LinkedList<>();

        for (int i = 0; i < theMap.length; i++){
            if(theMap[i] != null){
                Entry<K,V> node = theMap[i];
                while(node != null){
                    vals.add(node.getValue());
                    node = node.next;
                }
            }
        }
        return vals;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        int size = makeMyValuesIntoALinkedList().size();
        return size;
    }

}

/**
        *A Key-Value Pair
 */

class Entry<K,V>{
    private K key;
    private V value;
    Entry next = null;

    Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}