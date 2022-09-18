package stream;

import static java.util.Arrays.asList;

import java.util.List;
import org.junit.jupiter.api.Test;

public class MersennePrimeTest {

    @Test
    void test() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        MersennePrime.execute(numbers).forEach(System.out::println);
    }
}
