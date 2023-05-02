package org.example.streamex;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

class ReduceExampleTest {

    @Test
    void case1() {
        int sum = Stream.of(1, 2, 3, 4, 5)
//            .reduce(0, (a, b) -> a + b);
            .reduce(0, Integer::sum);

        System.out.println(sum);
    }

    @Test
    void case2() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int sum = numbers.stream()
            .reduce((x, y) -> x + y)
            .get();

        System.out.println(sum);
    }

    @Test
    void case3() {
        List<String> numberStrList = List.of("1", "2", "3", "4", "5");

        int sum = numberStrList.stream()
            .reduce(0, (number, str) -> number + Integer.parseInt(str), Integer::sum);

        System.out.println(sum);
    }
}
