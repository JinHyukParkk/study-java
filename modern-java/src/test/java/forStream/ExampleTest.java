package forStream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void testFor() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        // Java 1부터 지원, 초기 for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


        // Java 5부터 지원, 가독성과 안정석 확보
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    void testStream() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        list.stream()
            .filter(number -> number > 3)
            .forEach(System.out::println);
    }

    @Test
    void testDivide() {
        List<Integer> list = List.of(3, 2, 1, 0);

        System.out.println(divideByFor(list, 0));
    }

    private int subtractByFor(int baseNumber, List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 == 0) {
                baseNumber -= number;
            }
        }

        return baseNumber;
    }

    private int subtractByStream(int baseNumber, List<Integer> numbers) {
        numbers.stream()
            .filter(number -> number % 2 == 0)
//            .forEach(number -> baseNumber -= number);  // 컴파일 에러남
            .collect(Collectors.toList());

        return baseNumber;
    }

    private double divideByFor(List<Integer> divided, int dividedNumber) {
        double sum = 0.0;
        for (int a : divided) {
            sum += a / dividedNumber;
        }

        return sum;
    }

    private double divideByStream(List<Integer> divided, int dividedNumber) {
        return IntStream.range(0, divided.size())
            .mapToDouble(index -> divided.get(index) / dividedNumber)
            .sum();
    }
}
