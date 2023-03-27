package com.example.reactive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

class OperationExampleTest {

    /*
     * zip 은 각각 스트림을 합쳐서 처리한다.
     * 각 latency가 길수록 같이 길어진다.
     *
     * */
    @Test
    @DisplayName("zip을 이용해 tuple로 받아보기")
    void case1() {
        Flux<Integer> f1 = Flux.range(0, 10);
        Flux<Integer> f2 = Flux.range(11, 20);
        Flux<Integer> f3 = Flux.range(21, 30);

        Flux.zip(f1, f2, f3)
            .map(tuple -> tuple.getT1() + " " + tuple.getT2() + " " + tuple.getT3())
            .doOnNext(System.out::println)
            .blockLast();
    }
}
