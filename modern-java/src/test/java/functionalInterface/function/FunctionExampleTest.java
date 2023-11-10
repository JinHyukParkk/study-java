package functionalInterface.function;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

class FunctionExampleTest {

    @Test
    void biFunction() {
        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> x + y;

        int result = add.apply(3, 5);
        System.out.println(result);
    }

    @Test
    void factorial() {
        Function<Integer, Integer> factorial = n -> calculateFactorial(n);

        int result1 = factorial.apply(5); // 결과는 120
        int result2 = factorial.apply(5); // 결과도 120

        System.out.println(result1);
        System.out.println(result2);
    }
    static int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
