package org.example.functionex;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

class ConsumerExampleTest {

    @Test
    void testConsumer() {
        Consumer<String> myStringConsumer = (String str) -> System.out.println(str);

        myStringConsumer.accept("hello");
        myStringConsumer.accept("world");

        List<Integer> integerInputs = Arrays.asList(4, 2, 3);
        Consumer<Integer> myIntegerProcessor =
            x -> System.out.println("Processing integer : " + x);
        process(integerInputs, myIntegerProcessor);

        List<Double> doubleInputs = Arrays.asList(4.1, 2.2, 3.3);
        Consumer<Double> myDoubleProcessor =
            x -> System.out.println("Processing double : " + x);
        process(doubleInputs, myDoubleProcessor);
    }

    public <T> void process(List<T> inputs, Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }

    @Test
    void testBiConsumer() {
        List<Double> doubleInputs = Arrays.asList(4.1, 2.2, 3.3);
        BiConsumer<Integer, Double> myDoubleProcessor =
            (index, input) -> System.out.println("Processing " + input + " at index " + index);
        getByIndex(doubleInputs, 2, myDoubleProcessor);

    }

    public <T> void getByIndex(List<T> inputs, int index, BiConsumer<Integer, T> processor) {
        processor.accept(index, inputs.get(index));
    }
}
