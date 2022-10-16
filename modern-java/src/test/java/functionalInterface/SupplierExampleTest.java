package functionalInterface;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class SupplierExampleTest {

    @Test
    void test() {
        Supplier<String> hello = () -> "hello";
        Supplier<String> world = () -> "world";

        System.out.println(String.format("%s, %s!", hello.get(), world.get()));
    }

    @Test
    void streamGenerateTest() {
        Supplier<Integer> randomNumbersSupplier = () -> ThreadLocalRandom.current().nextInt(20);

        Stream.generate(randomNumbersSupplier)
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    void befortLazyTest() {
        long start = System.currentTimeMillis();

        SupplierExample.printWithValue(100, SupplierExample.getExpensiveValue());
        SupplierExample.printWithValue(50, SupplierExample.getExpensiveValue());
        SupplierExample.printWithValue(10, SupplierExample.getExpensiveValue());

        System.out.println(
                String.format("총 걸린 시간 : %d초", (System.currentTimeMillis() - start) / 1000));
    }

    @Test
    void afterLazyTest() {
        long start = System.currentTimeMillis();

        SupplierExample.printWithSupplier(100, () -> SupplierExample.getExpensiveValue());
        SupplierExample.printWithSupplier(50, () -> SupplierExample.getExpensiveValue());
        SupplierExample.printWithSupplier(10, () -> SupplierExample.getExpensiveValue());

        System.out.println(
                String.format("총 걸린 시간 : %d초", (System.currentTimeMillis() - start) / 1000));
    }
}
