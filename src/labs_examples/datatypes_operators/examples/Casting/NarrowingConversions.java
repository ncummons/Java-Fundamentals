package labs_examples.datatypes_operators.examples.Casting;

public class NarrowingConversions {

    public static void main(String[] args) {

        double x = 10.92312341234;
        // double "x" is being casted to an (int) "z" below
        System.out.println("double value: x = " + x);
        float f = (float) x;
        System.out.println("float value " + f);
        int z = (int) x;
        System.out.println("int value: z = " + z);
        // more examples
        double d = 100.04;
        // cast double "d" to long "l" - explicit type casting required
        long l = (long) d;
        // cast long "l" to int "i" - explicit type casting required
        int i = (int) l;

        System.out.println("double value " + d);
        System.out.println("long Value " + l);
        System.out.println("int value " + i);
    }
}
