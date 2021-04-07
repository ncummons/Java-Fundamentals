package labs_examples.arrays.examples;

// Some String operations.
class StrOps {
    public static void main(String args[]) {
        String str1 = "When it comes to programming, Java is #1.";
        String str2 = "When it comes to programming, Java is #1.";
        String str3 = "Java strings are powerful.";
        int result, idx;

        if (str1.equalsIgnoreCase(str2)){
            System.out.println("this shouldn't print");
        }

        System.out.println("Length of str1: " +
                str1.length());

        // display str1, one char at a time.
        for(int i=0; i < str1.length(); i++)
            System.out.print(str1.charAt(i));

        System.out.println();

        if(str1.equals(str2))
            System.out.println("str1 equals str2");
        else
            System.out.println("str1 does not equal str2");

        if(str1.equals(str3))
            System.out.println("str1 equals str3");
        else
            System.out.println("str1 does not equal str3");

        result = str1.compareTo(str3);

        if(result == 0)
            System.out.println("str1 and str3 are equal");
        else if(result < 0)
            System.out.println("str1 is less than str3");
        else
            System.out.println("str1 is greater than str3");


        // assign a new string to str2
        str2 = "One Two Three One";

        idx = str2.indexOf("One");
        System.out.println("Index of first occurence of One: " + idx);
        idx = str2.lastIndexOf("One");
        System.out.println("Index of last occurence of One: " + idx);

        char[] charArray = new char[str1.length()];
        charArray = str1.toCharArray();
        System.out.println(charArray[1]);
        for(char letter: charArray){
            System.out.print(letter + "|");
        }

    }
}