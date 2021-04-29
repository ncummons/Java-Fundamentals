package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 2: File encryption
 *
 *      -Using the BufferedReader, read a file character by character and write an encrypted version to a new file.
 *      -For example, change every 'a' to '-' and every 'e' to '~' .
 *      -Make sure you close the connections to both files. --> I used a "try-with-resources" to ensure that
 *      the files were automatically closed and it is less verbose.
 *
 *      Then, read back the encrypted file using the BufferedReader and
 *      print out the unencrypted version. Does it match the original file?
 *
 */

class Exercise_02{

    // Read from file and write to new file with changes and then system output to console from the encrypted new file
    // to verify that it is the same as the original file, reading through the changes.

    public static void main(String[] args) {

        String fromFilePath = "src/labs_examples/input_output/files/char_data.txt";
        String toFilePath = "src/labs_examples/input_output/files/encrypted_char_data.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(fromFilePath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(toFilePath))){
            int c;
            while((c = br.read()) != -1){
                if ((char) c == 'a') c = ')';
                if ((char) c == 'e') c = '$';
                if ((char) c == 'o') c = '|';
                if ((char) c == 't') c = '>';
                bw.write((int) c);
            }

        }catch(IOException ioException){
            ioException.printStackTrace();
        }

        // Here I will print out the text from the encrypted file to the console,
        // changing the characters back to the originals

        try(BufferedReader br = new BufferedReader(new FileReader(toFilePath))){
            int c;
            while((c = br.read()) != -1){
                if ((char) c == ')') c = 'a';
                if ((char) c == '$') c = 'e';
                if ((char) c == '|') c = 'o';
                if ((char) c == '>') c = 't';
                System.out.print((char) c);
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        System.out.println("Done reading, writing, and printing");

    }

}

