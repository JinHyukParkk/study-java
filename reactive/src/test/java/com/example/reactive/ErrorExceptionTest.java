package com.example.reactive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @Test
    @DisplayName("subscribe에서 에러 발생 시 핸들링 해본다.")
    void case4() {
        Flux.just(1, 2, 3)
            .map(i -> {
                if (i == 2) {
                    throw new RuntimeException("error");
                }
                return i;
            })
            .subscribe(
                (data) -> System.out.println(data),
                (error) -> System.out.println(error),
                () -> System.out.println("complete"));
    }

    @Test
    @DisplayName("onErrorReturn으로 에러 발생시 -1 을 넘긴다.")
    void case5() {
        Flux.just(1, 2, 3)
            .map(i -> {
                if (i == 2) {
                    throw new RuntimeException("error");
                }
                return i;
            })
            .onErrorReturn(-1)
            .subscribe(
                (data) -> System.out.println(data),
                (error) -> System.out.println(error),
                () -> System.out.println("complete"));
    }

    @Test
    @DisplayName("onErrorResume으로 에러 발생 시 새로운 스트림을 생성한다.")
    void case6() {
        Flux.just(1, 2, 3)
            .map(i -> {
                if (i == 2) {
                    throw new RuntimeException("error");
                } else if (i == 4) {
                    throw new RuntimeException("error2");
                }
                return i;
            })
            .onErrorResume(e -> Flux.just(4, 5, 6))
            .subscribe(
                (data) -> System.out.println(data),
                (error) -> System.out.println(error),
                () -> System.out.println("complete"));
    }

    @Test
    @DisplayName("onErrorMap으로 에러 발생 시 새로운 에러를 생성한다.")
    void case7() {
        Flux.just(1, 2, 3)
            .map(i -> {
                if (i == 2) {
                    throw new RuntimeException("error");
                }
                return i;
            })
            .onErrorMap(error -> new IllegalArgumentException("error"))
            .subscribe(
                (data) -> System.out.println(data),
                (error) -> System.out.println(error),
                () -> System.out.println("complete"));
    }

    @Test
    @DisplayName("onErrorContinue로 에러 발생 시 에러를 처리하고, 나머지 스트림을 처리한다.")
    void case8() {
        Flux.just(1, 2, 3)
            .map(i -> {
                if (i == 2) {
                    throw new RuntimeException("error");
                }
                return i;
            })
            .onErrorContinue((error, data) -> System.out.println("error: " + error + ", data: " + data))
            .subscribe(
                (data) -> System.out.println(data),
                (error) -> System.out.println(error.toString()),
                () -> System.out.println("complete"));
    }
}
