package com.example.reactive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

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

    @Test
    @DisplayName("첫번째 요소를 가져와 확인하는 방법")
    void test2() {
        Flux<Integer> flux = Flux.just(0, 1, 2);

        StepVerifier.create(flux ,1)
            .expectNext(0)
            .thenRequest(1)    // 다음 Request 요청
            .expectNext(1)
            .thenRequest(1)
            .expectNext(2);
    }
}
