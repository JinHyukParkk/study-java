package stream.grammer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduce {

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

    @Test
    void sumTest() {
        int sum = numbers.stream().reduce(0, Integer::sum);

        System.out.println(sum);
    }

    @Test
    void sumTestWithoutInitValue() {
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);

        System.out.println(sum);
    }

    @Test
    void sumTestWithoutInitValueAndList() {
        List<Integer> numbers = Arrays.asList();

        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);

        System.out.println(sum);
    }

    @Test
    void maxTest() {
        Optional<Integer> max = numbers.stream().reduce(Integer::max);

        System.out.println(max);
    }
}
