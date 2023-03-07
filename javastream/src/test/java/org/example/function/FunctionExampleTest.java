package org.example.function;

import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class FunctionExampleTest {

    @Test
    void biFunction() {
        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> x + y;

        int result = add.apply(3, 5);
        System.out.println(result);
    }
}
