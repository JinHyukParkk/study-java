package com.example.reactive;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class MergeExampleTest {

    @Test
    void mergeTest() {
        Flux<Long> flux1 = Flux.interval(Duration.ofMillis(100)).take(10);
        Flux<Long> flux2 = Flux.just(100L, 101L, 102L);

        flux1.mergeWith(flux2)
                .doOnNext(System.out::println)
                .blockLast();
    }

    @Test
    void concatTest() {
        Flux<Long> flux1 = Flux.interval(Duration.ofMillis(100)).take(10);
        Flux<Long> flux2 = Flux.just(100L, 101L, 102L);

        flux1.concatWith(flux2)
                .doOnNext(System.out::println)
                .blockLast();
    }

    @Test
    void monoConcatTest() {
        Mono<Integer> mono1 = Mono.just(1);
        Mono<Integer> mono2 = Mono.just(2);

        Flux.concat(mono1, mono2)
                .doOnNext(System.out::println)
                .blockLast();
    }
}
