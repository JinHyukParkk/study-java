package org.example.streamex;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

class FindExampleTest {


    @Test
    void case1() {
        Optional<Integer> anyNegativeInteger = Stream.of(-2, -4, -3, 2, -5, 6, -7)
            .filter(x -> x < 0)
            .findAny();
        System.out.println(anyNegativeInteger.get());
    }

    @Test
    void case2() {
        Optional<Integer> firstNegativeInteger = Stream.of(-2, -4, -3, 2, -5, 6)
            .filter(x -> x < 0)
            .findFirst();
        System.out.println(firstNegativeInteger.get());
    }
}
