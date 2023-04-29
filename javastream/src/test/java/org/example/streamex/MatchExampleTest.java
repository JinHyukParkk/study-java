package org.example.streamex;

import org.junit.jupiter.api.Test;

import java.util.List;

class MatchExampleTest {


    @Test
    void case1() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        boolean allPostive = numbers.stream()
            .allMatch(number -> number > 0);

        System.out.println("Are all numbers positive : " + allPostive);
    }

    @Test
    void case2() {
        List<Integer> numbers = List.of(3, -4, 3, 4, 5);

        boolean anyNegative = numbers.stream()
            .anyMatch(number -> number < 0);

        System.out.println("Is any number negative : " + anyNegative);
    }
}
