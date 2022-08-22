package stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamFilterTest {

    @Test
    void takewhileTest() {
        List<Integer> intList = Arrays.asList(5, 2, 3, 4, 1, 3, 6, 1, 2, 3, 4);

        List<Integer> sliceNum = intList.stream()
                .takeWhile(num -> num < 3)
                .collect(toList());

        sliceNum.forEach(System.out::println);
    }

    @Test
    void dropwhileTest() {
        List<Integer> intList = Arrays.asList(5, 2, 3, 4, 1, 3, 6, 1, 2, 3, 4);

        List<Integer> sliceNum = intList.stream()
                .dropWhile(num -> num < 3)
                .collect(toList());

        sliceNum.forEach(System.out::println);
    }
}
