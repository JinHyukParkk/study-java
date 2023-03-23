package com.example.reactive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.Exceptions;
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

    @Test
    @DisplayName("Mono 처리 중 map 과정에서 에러 발생 시 200 값으로 처리한다.")
    void case3() {
        Mono.just("hello")
            .log()
            .map(s -> {
                int value = 0;
                try {
                    Integer.parseInt(s);
                } catch (Exception e) {
                    throw Exceptions.propagate(e);  // Checked Exception 을 Unchecked Exception 으로 감싸줌
                }
                return value;
            })
            .onErrorReturn(200)
            .doOnNext(System.out::println)
            .subscribe();

    }
}
