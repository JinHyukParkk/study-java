package com.example.reactive;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;

class AdaptExampleTest {

    @Test
    @DisplayName("어떠한 publisher를 바꿔 낄 수 있는 flowable - Flux에서 Flowable로 바꾸기")
    void case1() {
        Flowable<Integer> flowable = Flowable.fromPublisher(Flux.just(2));

        Flux.from(flowable);

    }

    /*
     *  Observable 은 backpressure가 없는거 같음. 그래서 Flux를 만들 때 Backpressure 설정을 하는 듯.
     * */
    @Test
    @DisplayName("Flux를 Observable로 바꾸기")
    void case2() {
        Flux<Integer> flux = Flux.just(2, 3);
        Observable<Integer> observable = Observable.just(2);

        Flux.from(observable.toFlowable(BackpressureStrategy.BUFFER));
        Observable.fromPublisher(flux);

        flux.log()
            .doOnNext(System.out::println)
            .blockLast();
    }

    @Test
    @DisplayName("Mono를 Single로, Single을 Mono로")
    void case3() {
        Mono<Integer> mono = Mono.just(2);
        Single<Integer> single = Single.just(2);

        Mono.from(single.toFlowable());
        Single.fromPublisher(mono);
    }

    @Test
    @DisplayName("Future를 Mono로 바꿔보기")
    void case4() {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> "hello");
        future.thenApply(s -> s.toString().toUpperCase());

        Mono<String> mono = Mono.just("hello")
            .map(String::toUpperCase);

        Mono.fromFuture(future);
    }

    /*
     * reator 안에는 이렇게 Adapter 코드들이 내제되어 있을거임
     *
     * */

    @Test
    @DisplayName("List를 Flux로 바꾸기")
    void case5() {
        List<Integer> dataList = List.of(1, 2, 3, 4, 5);

        // Flux.fromIterable
        Flux<Integer> reactiveStream = Flux.fromIterable(dataList);

        reactiveStream
            .map(i -> i * 2) // Transform each element
            .doOnNext(i -> System.out.println("Processed: " + i)) // Side-effect
            .subscribe(); // Subscribe to the reactive stream
    }
}
