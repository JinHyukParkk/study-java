package com.example.reactive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class TransformExampleTest {

    @Test
    void mapTest() {
        StepVerifier.create(Mono.just("hello")
                .map(s -> s.toUpperCase()))
            .expectNext("HELLO")
            .verifyComplete();
    }

    @Test
    @DisplayName("리엑티브 값 테스트 방법")
    void reactorTest() {
        // Create a Flux of integers from 1 to 5
        Flux<Integer> flux = Flux.range(1, 5);

        // Test the Flux using StepVerifier
        StepVerifier.create(flux)
            .expectNext(1, 2, 3, 4, 5) // Expect each item to be emitted in order
            .expectComplete() // Expect the Flux to complete successfully
            .verify(); // Perform the verification
    }
}
