package labs_examples.lambdas.labs;

import java.nio.channels.ConnectionPendingException;
import java.util.function.*;

/**
 * Lambdas Exercise 2:
 *
 *      1) Demonstrate the use of 10 pre-built Functional Interfaces from the java.util.functions package. That's right,
 *      10 of them! You can do it! You'll know so much about them when you're done!
 *
 */

    // 1. BiConsumer
    // 2. Consumer
    // 3. Supplier
    // 4. BiPredicate
    // 5. IntFunction
    // 6. UnaryOperator
    // 7. IntSupplier
    // 8. DoublePredicate
    // 9. LongSupplier
    // 10. LongToIntFunction

class MainMethodClass{
    public static void main(String[] args) {

        // 1. BiConsumer
        BiConsumer<Integer, String> biConsumer = (x, word) -> System.out.println("Consuming: " + x + " and " + word);
        biConsumer.accept(15, "Hamburger");

        // 2. Consumer
        Consumer<Double> consumer = (d) -> System.out.println("Accepting a double: " + d);
        double doub = Math.sqrt(26);
        consumer.accept(doub);

        // 3. Supplier

        int score = 100;
        Supplier<Integer> supplyScore = () -> score;
        System.out.println("Your current score is: " + supplyScore.get());

        // 4. BiPredicate
        int opponentScore = 1200;
        BiPredicate<Integer, Integer> isGreaterThan = (x, y) -> x > y;
        if(isGreaterThan.test(score, opponentScore)){
            System.out.println("You win!");
        }else{
            System.out.println("You lose!");
        }

        // 5. IntFunction
        IntFunction<String> tellNumArrows = (x) -> "You have " + x + " arrows left.";
        int arrows = 15;
        System.out.println(tellNumArrows.apply(arrows));

        // 6. UnaryOperator

        UnaryOperator<Double> divideByThree = d -> d/3.0;
        System.out.println("9.9 divided by 3.0 is: " + divideByThree.apply(9.9));

        // 7. IntSupplier

        IntSupplier supplier = () -> arrows - 10;
        int dollars = supplier.getAsInt();
        while(dollars > 0){
            dollars--;
            System.out.println("You lose a dollar. You have: $" + dollars);
        }if(dollars == 0){
            System.out.println("You are out of money.");
        }

        // 8. DoublePredicate

        double distance = 100.0;
        DoublePredicate equalsSqrtDistance = d -> Math.sqrt(distance) == d;

        System.out.println(equalsSqrtDistance.test(10.0));
        System.out.println(equalsSqrtDistance.test(14.0));

        // 9. LongSupplier

        LongSupplier getLong = () -> 16l;
        System.out.println("I have " + getLong.getAsLong() + " candles.");

        // 10. LongToIntFunction
        LongToIntFunction longToIntFunction =(l) -> (int)l / 4;
        int intVal = longToIntFunction.applyAsInt(getLong.getAsLong());
        System.out.println(intVal);

    }
}