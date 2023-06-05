package org.example.functionex;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.example.functionex.ScopeExample.getStringSupplier;

class ScopeExampleTest {

    @Test
    void case1() {
        Supplier<String> supplier = getStringSupplier();
        System.out.println(supplier.get());

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        // Curry
        Function<Integer, Function<Integer, Integer>> curriedAdd = a -> b -> a + b;
        Function<Integer, Integer> addThree = curriedAdd.apply(3);  // b -> 3 + b
        int result = addThree.apply(5); // 5 + 3
        System.out.println(result);
    }
}
