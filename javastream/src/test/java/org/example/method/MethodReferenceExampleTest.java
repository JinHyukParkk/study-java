package org.example.method;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MethodReferenceExampleTest {

    @Test
    void case1() {
        Function<String, Integer> str2int = Integer::parseInt;
        int five = str2int.apply("5");

        assertEquals(5, five);
    }

    @Test
    void case2() {
        String str = "hello";
        Predicate<String> equalsToHello = str::equals;

        boolean helloEqualsWorld = equalsToHello.test("world");

        assertFalse(helloEqualsWorld);
    }

    @Test
    void case3() {
        int sum = calculate(8, 2, (x, y) -> x + y);

        assertEquals(10, sum);
    }

    @Test
    void case4() {
        int mul = calculate(8, 2, MethodReferenceExampleTest::multiply);

        assertEquals(16, mul);
    }

    @Test
    void case5() {
        MethodReferenceExampleTest instance = new MethodReferenceExampleTest();
        int sub = calculate(8, 2, instance::subtract);

        assertEquals(6, sub);
    }

    @Test
    void case6() {
        int sub = calculate(8, 2, this::subtract);

        assertEquals(6, sub);
    }

    private int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }
}
