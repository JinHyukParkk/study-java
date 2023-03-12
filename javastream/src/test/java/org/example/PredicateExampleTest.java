package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class PredicateExampleTest {

    @Test
    void test() {
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(10));
    }

    @Test
    void test1() {
        Predicate<Integer> isPositive = x -> x > 0;
        List<Integer> inputs = Arrays.asList(10, -5, 4, -2, 0);
        System.out.println("Positive number : "
                + filter(inputs, x -> x > 0));
        System.out.println("Non-positive number : "
                + filter(inputs, isPositive.negate()));
        System.out.println("Non-negative number : "
                + filter(inputs, isPositive.or(x -> x == 0)));
        System.out.println("Positive even numbers : "
                + filter(inputs, isPositive.and(x -> x % 2 == 0)));
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
