package com.example.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

class MonoExampleTest {

    @Test
    void test() {
        Mono.just(100L)
                .map(i -> i * 2)
                .or(Mono.just(1L))
                .subscribe(System.out::println);

        System.out.println("비동기?!");
    }

    @Test
    void neverTest() {
        Mono.never();
    }

    @Test
    void errorTest() {
        Mono.error(new IllegalAccessException())
                .subscribe(System.out::println);
    }
}
