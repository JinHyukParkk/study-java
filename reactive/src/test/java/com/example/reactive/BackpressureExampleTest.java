package com.example.reactive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

class BackpressureExampleTest {

    /**
     * reactor 에서 따로 backpressure 조절은 안해줌 (unbouned 임)
     * Webflux 에서 해줌
     */
    @Test
    @DisplayName("그냥 4번 찍어봄")
     void test() {
        Flux<Long> flux = Flux.interval(Duration.ofMillis(100)).take(4).log();
        flux.doOnNext(System.out::println)
            .blockLast();
    }
}
