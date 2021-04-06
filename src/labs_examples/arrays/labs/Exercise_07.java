package labs_examples.arrays.labs;
import java.util.ArrayList;
/**
 *  ArrayLists
 *
 *      Please demonstrate how to create an ArrayList, populate an array list, access elements within an ArrayList.
 *      Also take a moment to explore the many methods that are available to you when you use an ArrayList. By simply
 *      typing the dot operator (".") after the ArrayList object that you create. You should see a menu pop up that
 *      shows a list of methods.
 *
 */
public class Exercise_07 {

    public static void main(String[] args) {

        ArrayList<String> testList = new ArrayList();

        testList.add("New");
        testList.add("list");
        testList.add("of");
        testList.add("strings.");

        for(String words: testList){
            System.out.print(words + " ");
        }
        System.out.println();

        testList.add(1, "(now even more new)");

        for(String words: testList){
            System.out.print(words + " ");
        }
        System.out.println();

        testList.set(1, "new");
        testList.add("There, that should be less wordy... right?");

        for(String words: testList){
            System.out.print(words + " ");
        }
        System.out.println();

        System.out.println("No, that is just awkward. Let's remove that.");

        testList.remove(1);

        for(String words: testList){
            System.out.print(words + " ");
        }
        System.out.println();

        String word = testList.get(1);
        System.out.println("The second element in the test list is: " + word);
        System.out.println("The length of the test list is: " + testList.size() + " elements.");

        testList.clear();

        if(testList.isEmpty()){
            System.out.println("Now the test list is empty...");
        }
        else{
            System.out.println("The test list is not empty.");
        }

    }

}
