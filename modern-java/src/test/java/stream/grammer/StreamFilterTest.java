package stream.grammer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamFilterTest {

    @Test
    void takewhileTest() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> sliceNum = intList.stream()
                .takeWhile(num -> num < 3)
                .collect(toList());

        sliceNum.forEach(System.out::println);
    }

    @Test
    void dropwhileTest() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> sliceNum = intList.stream()
                .dropWhile(num -> num < 3)
                .collect(toList());

        sliceNum.forEach(System.out::println);
    }

    @Test
    void skipTest() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> sliceNum = intList.stream()
                .skip(3)
                .collect(toList());

        sliceNum.forEach(System.out::println);
    }
}
