package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class PredicateExampleTest {

    @Test
    void test() {
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(10));
    }

    @Test
    void test1() {
        List<Integer> inputs = Arrays.asList(10, -5, 4, -2, 0);
        System.out.println("Positive number : " + filter(inputs, x -> x > 0));
    }

    private <T> List<T> filter(List<T> inputs, Predicate<T> condition) {
        List<T> output = new ArrayList<>();
        for (T input : inputs) {
            if (condition.test(input)) {
                output.add(input);
            }
        }
        return output;
    }
}
