package functionalInterface.function;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FunctionExampleTest {

    @Test
    void biFunction() {
        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> x + y;

        int result = add.apply(3, 5);
        System.out.println(result);
    }

    @Test
    void factorialTest() {
        Function<Integer, Integer> factorial = n -> calculateFactorial(n);

        int result1 = factorial.apply(5); // 결과는 120
        int result2 = factorial.apply(5); // 결과도 120

        System.out.println(result1);
        System.out.println(result2);
    }
    private static int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    @Test
    @DisplayName("함수형 프로그래밍에서의 영속 개념")
    void testPersistence() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 기존 리스트를 변경하지 않고 새로운 리스트를 생성
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());

        // 원본 리스트 출력
        System.out.println("Original List: " + numbers);

        // 새로운 리스트 출력
        System.out.println("Even Numbers: " + evenNumbers);
    }
}
