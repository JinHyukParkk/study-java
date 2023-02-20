package com.example.reactive;

import static reactor.core.scheduler.Schedulers.parallel;

import java.util.List;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

class FlatMapExampleTest {

    @Test
    void flatMapTest() {
        Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .window(3)
                .flatMap(l -> l.map(this::toUpperCase))
                .doOnNext(System.out::println)
                .blockLast();
    }

    @Test
    void flatMapParallelTest() {
        Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .window(3)
                .flatMap(l -> l.map(this::toUpperCase).subscribeOn(parallel()))
                .doOnNext(System.out::println)
                .blockLast();
    }

    @Test
    void concatMapTest() {
        Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .window(3)
                .concatMap(l -> l.map(this::toUpperCase).subscribeOn(parallel()))
                .doOnNext(System.out::println)
                .blockLast();

        // concatMap은 순서를 보장하기 때문에 parallel이 의미가 없다.
    }

    @Test
    void flatMapSequentialTest() {
        Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .window(3)
                .flatMapSequential(l -> l.map(this::toUpperCase).subscribeOn(parallel()))
                .doOnNext(System.out::println)
                .blockLast();

        // 비동기적인데 병렬이 가능하고, 순서가 보장된다.
    }

    public List<String> toUpperCase(String s) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return List.of(s.toUpperCase(), Thread.currentThread().getName());
    }
}
