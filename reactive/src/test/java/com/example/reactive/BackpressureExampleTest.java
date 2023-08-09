package com.example.reactive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;

class BackpressureExampleTest {

    /**
     * reactor 에서 따로 backpressure 조절은 안해줌 (unbouned 임)
     * Webflux 에서 해줌
     */
    @Test
    @DisplayName("그냥 4번 찍어봄")
    void test() {
        Flux<Long> flux = Flux.interval(Duration.ofMillis(100)).take(4).log();
        flux.doOnNext(System.out::println)
            .blockLast();
    }

    /*
     * StepVerifier 는 verify 관련 메서드로 끝내야 함
     * */
    @Test
    @DisplayName("첫번째 요소를 가져와 순차적으로 확인하는 방법")
    void test2() {
        Flux<Integer> flux = Flux.just(0, 1, 2, 3).log();

        StepVerifier.create(flux, 1)
            .expectNext(0)
            .thenRequest(1)    // 다음 Request 요청
            .expectNext(1)
            .thenRequest(1)
            .expectNext(2)
            .thenCancel()       // 다음 요소를 구독하지 않고, StepVerifier 반환
            .verify();
    }

    @Test
    @DisplayName("요소들 로그 찍기")
    void test3() {
        Flux.just(0, 1, 2).log()
            .doOnNext(System.out::println)
            .blockLast();
    }

    @Test
    @DisplayName("Flux 여러 처리 과정 테스트")
    void test4() {
        Flux.just(0, 1, 2)
            .doOnSubscribe(s -> System.out.println("Starring :"))
            .doOnNext(System.out::println)
            .doOnComplete(() -> System.out.println("The end!"))
            .blockLast();
    }

    @Test
    @DisplayName("Backpressure")
    void test5() {
        Flux.range(1, 100)
            .log()
            .doOnNext(System.out::println)
            .subscribe(new Subscriber<Integer>() {

                private Subscription subscription;
                private int count;

                @Override
                public void onSubscribe(Subscription subscription) {
                    this.subscription = subscription;
                    this.subscription.request(10);
                }

                @Override
                public void onNext(Integer integer) {
                    count++;
                    if ((count & 10) == 0) {
                        this.subscription.request(10);
                    }
                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onComplete() {
                    System.out.println("FINISH");
                }
            });
    }

    @Test
    @DisplayName("Backpressure 예제")
    void test6() throws InterruptedException {
        // Create a Flux that emits integers from 1 to 1000
        Flux<Integer> numbersFlux = Flux.range(1, 1000);

        // Simulate a slow subscriber by consuming elements with a delay
        numbersFlux
            .log()
            .doOnNext(i -> {
                // Simulate some slow processing
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            })
            // Subscribe on a separate scheduler to introduce concurrency
            .subscribeOn(Schedulers.parallel())
            .subscribe(
                // onNext: Print the received element
                num -> System.out.println("Received: " + num),
                // onError: Handle errors
                Throwable::printStackTrace,
                // onComplete: Called when the Flux completes
                () -> System.out.println("Completed!")
            );

        // Wait for a while to observe backpressure in action
        Thread.sleep(10000);
    }

    @Test
    void test7() {
        Flux<Integer> fastProducer = Flux.range(1, 1000); // Produces 1 to 1000

        fastProducer
            .doOnNext(data -> System.out.println("Producing: " + data))
            .limitRate(10) // Applying backpressure: Limit to processing 10 items at a time
            .subscribe(
                data -> {
                    // Simulating slow processing
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Consuming: " + data);
                },
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Completed")
            );
    }
}
