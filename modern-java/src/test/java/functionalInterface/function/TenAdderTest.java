package functionalInterface.function;

import java.util.function.Function;
import org.junit.jupiter.api.Test;

class TenAdderTest {

    @Test
    void test() {
        Function<Integer, Integer> myAdder = new TenAdder();
        int result = myAdder.apply(5);
        System.out.println(result);
    }

    @Test
    void convertLambdaTest() {
        Function<Integer, Integer> myAdder = (Integer x) -> x + 10;
        int result = myAdder.apply(5);
        System.out.println(result);
    }
}
