package stream.grammer;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class StreamReduceTest {

    @Test
    void reduceTest() {
        int sum = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .reduce((a, b) -> a + b)
                .getAsInt();

        System.out.println(sum);

        sum = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .reduce(Integer::sum)
                .getAsInt();

        System.out.println(sum);
    }

    @Test
    void reduceWithInitValue() {
        int sum = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .reduce(10, (a, b) -> a + b);

        System.out.println(sum);
    }
}
