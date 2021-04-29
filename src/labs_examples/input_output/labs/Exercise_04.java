package labs_examples.input_output.labs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 *      Following the video examples and source code found in the src/labs_examples/input_output/examples/csv_parser
 *      package, create a new application that will parse a custom CSV file that you created and map each line of the
 *      csv to a custom POJO that you create.
 *
 *      Then add that object to an arraylist. After you have mapped each row of the csv to objects
 *      and added each object to an arraylist, print out each object using the objects custom toString() method.
 *
 *      Then, write the arraylist of objects back out to a new .csv file. Ensure that the resulting csv file is valid.
 *
 */

class Exercise_04{

    public static void main(String[] args) {

        ArrayList<Guitar> guitars = new ArrayList<>();

        String filePath = "src/labs_examples/input_output/files/guitarCSV.csv";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){

            String line;

            while((line = bufferedReader.readLine()) != null){
                String[] values = line.split(",");
                guitars.add(mapValuesToGuitar(values));
            }

        }catch(FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException){
            ioException.printStackTrace();
        }

        for(Guitar guitar : guitars){
            System.out.println(guitar.toString());
        }

    }

    private static Guitar mapValuesToGuitar(String[] values){
        Guitar guitar = new Guitar();
        guitar.setManufacturer(values[0]);
        guitar.setModel(values[1]);
        guitar.setNumFrets(Integer.parseInt(values[2]));
        guitar.setNumStrings(Integer.parseInt(values[3]));
        guitar.setDoubleNeck(Boolean.parseBoolean(values[4]));
        guitar.setElectric(Boolean.parseBoolean(values[5]));
        guitar.setRetailPrice(Double.parseDouble(values[6]));

        return guitar;
    }

}

class Guitar{

    private String manufacturer;
    private String model;
    private int numFrets;
    private int numStrings;
    private boolean isDoubleNeck;
    private boolean isElectric;
    private double retailPrice;

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumFrets(int numFrets) {
        this.numFrets = numFrets;
    }

    public void setNumStrings(int numStrings) {
        this.numStrings = numStrings;
    }

    public void setDoubleNeck(boolean doubleNeck) {
        isDoubleNeck = doubleNeck;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Guitar() {
    }

    public Guitar(String manufacturer, String model, int numFrets, int numStrings, boolean isDoubleNeck, boolean isElectric, double retailPrice) {
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setNumFrets(numFrets);
        this.setNumStrings(numStrings);
        this.setDoubleNeck(isDoubleNeck);
        this.setElectric(isElectric);
        this.setRetailPrice(retailPrice);
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "manufacturer='" + getManufacturer() + '\'' +
                ", model='" + getModel() + '\'' +
                ", numFrets=" + getNumFrets() +
                ", numStrings=" + getNumStrings() +
                ", isDoubleNeck=" + isDoubleNeck() +
                ", isElectric=" + isElectric() +
                ", retailPrice=" + getRetailPrice() +
                '}';
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getNumFrets() {
        return numFrets;
    }

    public int getNumStrings() {
        return numStrings;
    }

    public boolean isDoubleNeck() {
        return isDoubleNeck;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public double getRetailPrice() {
        return retailPrice;
    }
}