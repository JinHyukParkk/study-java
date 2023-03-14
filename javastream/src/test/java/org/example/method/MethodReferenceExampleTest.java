package org.example.method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MethodReferenceExampleTest {

    @Test
    @DisplayName("클래스의 static method를 지정하는 것과 같다.")
    void case1() {
        Function<String, Integer> str2int = Integer::parseInt;
        int five = str2int.apply("5");

        assertEquals(5, five);
    }

    @Test
    @DisplayName("선언된 객체의 instance method를 지정하는 것과 같다.")
    void case2() {
        String str = "hello";
        Predicate<String> equalsToHello = str::equals;

        boolean helloEqualsWorld = equalsToHello.test("world");

        assertFalse(helloEqualsWorld);
    }

    @Test
    @DisplayName("람다식을 지정한다.")
    void case3() {
        int sum = calculate(8, 2, (x, y) -> x + y);

        assertEquals(10, sum);
    }

    @Test
    @DisplayName("클래스의 static method를 지정한다.")
    void case4() {
        int mul = calculate(8, 2, MethodReferenceExampleTest::multiply);

        assertEquals(16, mul);
    }

    @Test
    @DisplayName("선언된 객체의 instance method를 지정한다.")
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

    @Test
    @DisplayName("해당 클래스의 인스턴스를 매개변수로 넘겨 메서드를 실행해주는 함수")
    void case7() {
        Function<String, Integer> strLength = String::length;
        int length = strLength.apply("Hello, world");

        assertEquals(12, length);

        BiPredicate<String, String> strEquals = String::equals;
        boolean result = strEquals.test("hello", "world");

        assertFalse(result);
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
