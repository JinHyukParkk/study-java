package org.example.functionex;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.functionex.LazyEvaluationExample.or;
import static org.example.functionex.LazyEvaluationExample.orLazy;
import static org.example.functionex.LazyEvaluationExample.returnFalse;
import static org.example.functionex.LazyEvaluationExample.returnTrue;

class LazyEvaluationExampleTest {


    @Test
    void case1() {
        if (true || returnTrue()) {
            System.out.println("true");
        }
    }

    @Test
    void case2() {
        if (or(returnTrue(), returnFalse())) {
            System.out.println("true");
        }
    }

    @Test
    void case3() {
        if (orLazy(LazyEvaluationExample::returnTrue, LazyEvaluationExample::returnFalse)) {
            System.out.println("true");
        }
    }

    @Test
    void case4() {
        Stream<Integer> integerStream = Stream.of(1, 12, -3, 44, 13)
            .filter(x -> x > 0)
            .peek(x -> System.out.println("filter: " + x))
            .filter(x -> x % 2 == 0);

        System.out.println("Before terminal operation");

        List<Integer> integers = integerStream.collect(Collectors.toList());
        System.out.println(integers);

    }
}
