package org.example.functionex;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

class FunctionCompositionExampleTest {

    @Test
    void case1() {
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> addTen = x -> x + 10;

        Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addTen);
        System.out.println(composedFunction.apply(3));
    }
}
