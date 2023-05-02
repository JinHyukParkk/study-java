package org.example.streamex;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class toMapExampleTest {

    @Test
    void case1() {
        Map<Integer, String> integerStringMap = Stream.of(3, 5, -4, 2, 6)
            .collect(Collectors.toMap(x -> x, x -> "value : " + x));

        System.out.println(integerStringMap);
    }

    @Test
    void case2() {
        Map<Integer, String> integerStringMap = Stream.of(3, 5, -4, 2, 6)
            .collect(Collectors.toMap(Function.identity(), x -> "value : " + x));

        System.out.println(integerStringMap);
    }
}
