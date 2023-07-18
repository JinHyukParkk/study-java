package com.example.reactive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

class FluxExampleTest {

    @Test
    void test() {
        Flux<String> flux = Flux.just("A", "B");
        Flux<String> flux2 = flux.map(i -> "foo" + i);
        flux.subscribe(System.out::println);
        flux2.subscribe(System.out::println);
    }

    @Test
    void test1() {
        Flux.fromIterable(List.of("foo", "bar"))
            .doOnNext(System.out::println)
            .map(String::toUpperCase)
            .subscribe(System.out::println);

        System.out.println("비동기?");
    }

    @Test
    void errorTest() {
        Flux.error(new IllegalStateException())
            .doOnEach(System.out::println)
            .subscribe();
    }

    @Test
    void intervalTest() throws InterruptedException {
        Flux.interval(Duration.ofMillis(100))
            .take(10)
            .subscribe(System.out::println);

        System.out.println("비동기?");

        Thread.sleep(5000);
    }

    @Test
    @DisplayName("Flux 와 List를 비교해본다")
    void fluxVsList() {
        System.out.println("List");
        IntStream.range(1, 11)
            .peek(i -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            })
            .forEach(System.out::println);

        System.out.println("Flux");
        Flux.range(1, 10)
            .delayElements(Duration.ofSeconds(1))
            .subscribe(System.out::println);
    }
}
