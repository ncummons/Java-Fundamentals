package labs_examples.datastructures.hashmap.labs;

import java.util.LinkedList;

/**
 *      HashMaps Exercise_02
 *
 *      Rewrite the CustomHashMap class to meet the following requirements:
 *      1) no method has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      2) no variable has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      3) resize the HashMap when the underlying array is more than half full
 *      4) triple the size of the underlying array on resize()
 *      5) instead of checking the number of keys to resize, check the number of values
 *      6) on collisions, add new elements to the front of the LinkedList, not the end
 *      7) anytime someone tries to get/update/remove an element that does not exist, print
 *          out a message indicating that the element does not exist
 *      8) add at least one more method that you think could be useful to the HashMap
 *          review Java's built-in HashMap for inspiration
 */

class CustomHashMap<K,V> {
    private Entry<K,V>[] table = new Entry[10];

    private int hash(K key){
        int index = Math.abs(key.hashCode() % table.length);
        return index;
    }

    public void put(K key, V value){
        int index = hash(key);
        Entry<K, V> entry = new Entry<>(key, value);

        if (table[index] == null){
            table[index] = entry;
        } else{
            Entry<K,V> p = table[index];
            while(p.next != null){
                p = p.next;
            }
            p.next = entry;
        }
        if (keys().size() > table.length * .75){
            resize();
        }
    }

    private void resize(){
        Entry<K,V>[] old = table;
        table = new Entry[old.length * 2];

        for(int i = 0; i <old.length; i++){
            try{
                Entry entry = old[i];
                put((K) entry.getKey(), (V) entry.getValue());

                while (entry.next != null) {
                    entry = entry.next;
                    put((K) entry.getKey(), (V) entry.getValue());
                }
            } catch (Exception e) {
            }
        }
    }

    public V get(K key){
        int index = hash(key);

        if(table[index] == null){
            return null;
        }
        Entry<K, V> entry = table[index];

        while(entry.getKey() != key){
            if(entry.next == null){
                return null;
            }
            entry = entry.next;
        }
        return entry.getValue();
    }

    public void remove(K key){
        if (get(key) == null){
            return;
        }
        int index = hash(key);
        Entry<K,V> entry = table[index];

        if(entry.getKey().equals(key)){
            table[index] = null;
        }
        while(entry.next != null) {
            if(entry.next.getKey() != key){
                entry = entry.next;
            }
        }
        if(entry.next.next != null){
            entry.next = entry.next.next;
        }
        else{
            entry.next = null;
        }
    }

    public LinkedList<K> keys(){
        LinkedList<K> keys = new LinkedList<>();

        for (int i = 0; i < table.length; i++){
            if(table[i] != null){
                Entry<K,V> p = table[i];
                while(p != null){
                    keys.add(p.getKey());
                    p = p.next;
                }
            }
        }
        return keys;
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