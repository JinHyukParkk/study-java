package com.example.reactive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class ErrorExceptionTest {

    @Test
    @DisplayName("Mono 중 에러가 발생했을 때 Mono를 리턴한다.")
    void case1() {
        Mono<Object> mono = Mono.error(new RuntimeException());

        mono.log().onErrorReturn(Mono.just(2))
            .doOnNext(System.out::println)
            .subscribe();
    }

    @Test
    @DisplayName("Mono 중 에러가 발생했을 때 Mono를 스트림으로 리턴한다.")
    void case2() {
        Mono<Object> mono = Mono.error(new RuntimeException());

        mono.log().onErrorResume(e -> Mono.just(2))
            .doOnNext(System.out::println)
            .subscribe();
    }
}
