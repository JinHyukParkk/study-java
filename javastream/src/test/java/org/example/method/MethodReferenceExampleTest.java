package org.example.method;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class MethodReferenceExampleTest {

    @Test
    void case1() {
        Function<String, Integer> str2int = Integer::parseInt;
        int five = str2int.apply("5");
    }

    @Test
    void case2() {
        String str = "hello";
        Predicate<String> equalsToHello = str::equals;

        boolean helloEqualsWorld = equalsToHello.test("world");
    }
}
