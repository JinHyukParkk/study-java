package function;

import org.example.function.TriFunction;
import org.junit.jupiter.api.Test;

class TriFunctionTest {

    @Test
    void test() {
        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers =
                (x, y, z) -> x + y + z;

        int result = addThreeNumbers.apply(1, 2, 3);
        System.out.println(result);
    }
}
