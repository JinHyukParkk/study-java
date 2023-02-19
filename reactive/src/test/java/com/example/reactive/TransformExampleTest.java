package com.example.reactive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class TransformExampleTest {

    @Test
    void mapTest() {
        StepVerifier.create(Mono.just("hello").map(s -> s.toUpperCase()))
                .expectNext("HELLO")
                .verifyComplete();
    }

}