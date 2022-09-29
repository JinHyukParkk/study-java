package lambda;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class lambdaPeek {

    @Test
    void test() {
        IntStream.range(0,10)
                .peek(x -> System.out.println(x))
                .map(x -> x + 20)
                .peek(x -> System.out.println(x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println(x))
                .limit(3)
                .peek(x -> System.out.println(x));
    }
}
