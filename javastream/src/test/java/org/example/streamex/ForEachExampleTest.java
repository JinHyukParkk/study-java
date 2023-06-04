package org.example.streamex;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ForEachExampleTest {

    @Test
    void case1() {
        List<Integer> numbers = Arrays.asList(3, 5, 2, 1);

        System.out.println("Stream forEach");
        numbers.stream().forEach(number -> System.out.println("The number is: " + number));

        System.out.println("Collection forEach");
        numbers.forEach(number -> System.out.println("The number is: " + number));
    }
}
