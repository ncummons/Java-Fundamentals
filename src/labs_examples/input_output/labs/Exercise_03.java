package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 3: variety
 *
 *    1) Demonstrate the usage of at least two additional Byte Streams
 *    2) Demonstrate the usage of at least two additional Character Streams
 *    3) Demonstrate using a buffer on one of the Byte Streams and one of the Character Streams
 *    4) Demonstrate the use of the DataInputStream and DataOutputStream
 *
 */

class Exercise_03 {

    public static void main(String[] args) {

        // 1.) Using two additional Byte Streams

        String fromFilePath = "src/labs_examples/input_output/files/byte_data_2";
        String toFilePath = "src/labs_examples/input_output/files/testFile";

        try (FileInputStream fileInputStream = new FileInputStream(fromFilePath);
             FileOutputStream fileOutputStream = new FileOutputStream(toFilePath)) {
            int c;
            while ((c = fileInputStream.read()) != -1) {
                fileOutputStream.write(c);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // 2.) Using two additional Character Streams

        fromFilePath = "src/labs_examples/input_output/files/char_data_2.txt";
        toFilePath = "src/labs_examples/input_output/files/char_data_2_copy.txt";

        try (FileReader fileReader = new FileReader(fromFilePath);
        FileWriter fileWriter = new FileWriter(toFilePath)) {
            int c;
            while((c = fileReader.read()) != -1){
                fileWriter.write(c);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // 3.) Using a buffer on each

        fromFilePath = "src/labs_examples/input_output/files/byte_data_2";
        toFilePath = "src/labs_examples/input_output/files/testFile";

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fromFilePath));
             FileOutputStream fileOutputStream = new FileOutputStream(toFilePath)) {
            int c;
            while ((c = bufferedInputStream.read()) != -1) {
                fileOutputStream.write(c);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        fromFilePath = "src/labs_examples/input_output/files/char_data_2.txt";
        toFilePath = "src/labs_examples/input_output/files/char_data_2_copy.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFilePath));
             FileWriter fileWriter = new FileWriter(toFilePath)) {
            int c;
            while((c = bufferedReader.read()) != -1){
                fileWriter.write(c);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // 4.) Using the Data Streams

        toFilePath = "src/labs_examples/input_output/files/data_stream_file";

        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(toFilePath))){
            int x = 10;
            double d = 15.6819;
            boolean isTrue = true;

            System.out.println("Writing: " + x);
            dataOutputStream.writeInt(x);
            System.out.println("Writing: " + d);
            dataOutputStream.writeDouble(d);
            System.out.println("Writing: " + isTrue);
            dataOutputStream.writeBoolean(isTrue);


        }catch(IOException ioException){
            ioException.printStackTrace();
        }

        fromFilePath = toFilePath;

        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fromFilePath))){
            int x;
            double d;
            boolean isTrue;
            x = dataInputStream.readInt();
            System.out.println("Reading: " + x);
            d = dataInputStream.readDouble();
            System.out.println("Reading: " + d);
            isTrue = dataInputStream.readBoolean();
            System.out.println("Reading: " + isTrue);
        }catch (IOException ioException){
            ioException.printStackTrace();
        }

        System.out.println("Completed program.");

    }
}

