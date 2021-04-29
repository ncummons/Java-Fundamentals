package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 1: File input/output
 *
 *      Using the BufferedInputStream, read a text file 5 bytes at a time and write each byte to a new file.
 *      Make sure you close the connections to both files.
 *
 *
 */

class Example {
    public static void main(String[] args) {

        String fromFilePath = "src/labs_examples/input_output/files/byte_data";
        String toFilePath = "src/labs_examples/input_output/files/copy_byte_data";

        FileInputStream fs = null;
        BufferedInputStream bis = null;
        FileOutputStream fo = null;
        BufferedOutputStream bos = null;


        try{
            // This array holds and subsequently prints out the bytes that we are reading/writing so that we
            // can verify that it is inputting/outputting 5 bytes each time
            byte[] buffArr = new byte[5];
            fs = new FileInputStream(fromFilePath);
            bis = new BufferedInputStream(fs,5);
            fo = new FileOutputStream(toFilePath);
            bos = new BufferedOutputStream(fo,5);
            int c;

            while((c = bis.read(buffArr)) != -1) {
                System.out.print(new String(buffArr, 0, c));
                bos.write(c);
            }

        }catch(IOException ioException){
            ioException.printStackTrace();
        } finally {
            try{
                if(bis != null){
                    bis.close();
                }
            }catch(IOException exc){
                System.out.println("There was an error closing the input stream.");
            } try{
                if(bis != null){
                    bos.close();
                }
            }catch(IOException exc){
                System.out.println("There was an error closing the output stream.");
            }

        }
        System.out.println("Done copying file.");

    }
}