package com.example.reactive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
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

        StepVerifier.create(flux ,1)
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
}
