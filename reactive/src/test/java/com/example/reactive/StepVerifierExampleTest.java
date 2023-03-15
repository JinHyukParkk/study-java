package com.example.reactive;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class StepVerifierExampleTest {

    @Test
    void test() {
        Flux<String> flux = Flux.just("foo", "bar");

        StepVerifier.create(flux)
                .expectNext("foo")
                .expectNext("bar")
                .verifyComplete();
    }

    @Test
    void errorTest() {
        Flux<String> flux = Flux.just("foo", "bar");

        StepVerifier.create(flux)
                .expectNext("foo")
                .expectNext("bar")
                .expectError();
    }

    @Test
    void assertThatTest() {
        Flux<User> users = Flux.just(new User("swhite"), new User("jpinkman"));
        StepVerifier.create(users)
                .assertNext(u -> assertThat(u.getUsername()).isEqualTo("swhite"))
                .assertNext(u -> assertThat(u.getUsername()).isEqualTo("jpinkman"))
                .verifyComplete();
    }

    @Test
    void intervalTest() {
        Flux<Long> take10 = Flux.interval(Duration.ofMillis(100))
            .take(10);

        StepVerifier.create(take10)
                .expectNextCount(10)
                .verifyComplete();
    }

    @Test
    void expectElement() {
        StepVerifier.withVirtualTime(() ->
                        Mono.delay(Duration.ofHours(3)))
                .expectSubscription()
                .expectNoEvent(Duration.ofHours(2)) // expectNoEvent를 쓸 땐 expectSubscription() 가 앞에 꼭 있어야함
                .thenAwait(Duration.ofHours(1))
                .expectNextCount(1)
                .verifyComplete();
    }

    public static class User {

        private String username;

        public User(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
