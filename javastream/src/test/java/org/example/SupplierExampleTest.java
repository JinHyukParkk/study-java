package org.example;

import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class SupplierExampleTest {

    @Test
    void test() {
        Supplier<String> myString = () -> "hello world";

        System.out.println(myString.get());

        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
        printRandomDoubles(myRandomDoubleSupplier, 5);
    }

    private void printRandomDoubles(Supplier<Double> randomSupplier, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }
}
