package com.example.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static reactor.core.scheduler.Schedulers.parallel;

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

    @Test
    void convertFlux() {
        Mono<List<String>> monoOfList = Mono.just(
            List.of("사과", "바나나", "딸기", "포도")
        );

        Flux<String> flattenedFlux = monoOfList.flatMapMany(Flux::fromIterable);

        flattenedFlux.subscribe(
            value -> System.out.println("변환된 값: " + value),
            error -> System.err.println("에러 발생: " + error),
            () -> System.out.println("스트림 종료")
        );
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
