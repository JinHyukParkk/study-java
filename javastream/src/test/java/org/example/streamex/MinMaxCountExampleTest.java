package org.example.streamex;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

class MinMaxCountExampleTest {

    @Test
    void maxTest() {
        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5)
            .max(Integer::compareTo);

        System.out.println(max.get());
    }

}
