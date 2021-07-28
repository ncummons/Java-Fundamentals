package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *  HashMaps Exercise_01
 *
 *  Demonstrate you're mastery of using Java's built-in HashMap class below.
 *
 *  Using a HashMap demonstrate the use of the following methods:
 *
 *  put()
 *  get()
 *  putAll()
 *  size()
 *  contains()
 *  keySet()
 *  entrySet()
 *  putIfAbsent()
 *  remove()
 *  replace()
 *  forEach()
 *  clear()
 *
 */
class HashPractice1{
    public static void main(String[] args) {

        HashMap<String, Integer> characters = new HashMap<>();

        characters.put("XXxPwned420xXX", 56);
        characters.put("MegaChad846", 101);
        characters.put("SimpleNick", 126);
        characters.put("nOT4sIMP", 42);

        int level = characters.get("SimpleNick");
        System.out.println("Your character is level: " + level);

        HashMap<String, Integer> characters2 = new HashMap<>();
        characters2.put("LatinMassLvr", 119);
        characters2.put("OLO Fatima", 101);
        characters.putAll(characters2);

        System.out.println("The hashmap has : "+ characters.size() + " elements.");
        boolean contains = characters.containsKey("LatinMassLvr");
        System.out.println("Your character is present in the \'Characters\' hashmap: " + contains);
        Set myKeys = characters.keySet();
        Iterator keyIt = myKeys.iterator();
        while(keyIt.hasNext()){
            System.out.print(keyIt.next() + ", ");
        }
        System.out.println();
        Set myEntries = characters.entrySet();
        Iterator entryIt = myEntries.iterator();
        while(entryIt.hasNext()){
            System.out.print(entryIt.next() + ", ");
        }
        System.out.println();

        characters.putIfAbsent("PUR3xK1LL3R", 89);
        int levelRemoved = characters.remove("XXxPwned420xXX");
        System.out.println(levelRemoved);

        boolean levelUp = characters.replace("OLO Fatima", 101, 102);
        if(levelUp){
            System.out.println("Level up successful.");
        }else{
            System.out.println("Failed to level up.");
        }
        characters.forEach((s, integer) -> System.out.println("Username: " + s + " | Level: " + integer));
        characters2.clear();
        characters2.forEach((s, integer) -> System.out.println("Username: " + s + " | Level: " + integer));
    }
}