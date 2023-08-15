package com.example.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

class TupleExampleTest {

    @Test
    void case1() {
        Flux<Integer> source1 = Flux.just(1, 2, 3);
        Flux<String> source2 = Flux.just("A", "B", "C");

        Flux<Tuple2<Integer, String>> zipped = Flux.zip(source1, source2);

        zipped.subscribe(tuple -> {
            int intValue = tuple.getT1();
            String stringValue = tuple.getT2();
            System.out.println("Value: " + intValue + ", String: " + stringValue);
        });
    }
}
