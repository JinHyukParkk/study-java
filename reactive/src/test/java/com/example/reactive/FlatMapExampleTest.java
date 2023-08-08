package com.example.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

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

    private List<String> toUpperCase(String s) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return List.of(s.toUpperCase(), Thread.currentThread().getName());
    }

    @Test
    public void testFlatMap() {

        Flux<String> flux = Flux.just("Hello", "Reactive", "Programming");

        // flatMap 은 내부적으로 추가 네트워크를 호출하거나 데이터베이스에서 데이터를 가져오는 등의 비동기 작업을 수행할 때 사용한다.
        // map은 단순한 변환 시 사용한다.
        Flux<Integer> lengthFlux = flux.flatMap(str -> Mono.just(str.length()));
//        Flux<Integer> lengthFlux = flux.map(str -> Mono.just(str.length()));

        // Test the transformed Flux using StepVerifier
        StepVerifier.create(lengthFlux)
            .expectNext(5, 8, 11) // Expect lengths of "Hello", "Reactive", and "Programming"
            .expectComplete() // Expect the Flux to complete successfully
            .verify();
    }
}
