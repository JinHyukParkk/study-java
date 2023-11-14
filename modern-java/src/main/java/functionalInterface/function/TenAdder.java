package functionalInterface.function;

import java.util.function.Function;

public class TenAdder implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
