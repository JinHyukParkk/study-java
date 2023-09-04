package parallel;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExampleExecutorTest {

    @Test
    void case1() throws InterruptedException {
        new ExampleExecutor().execute();
    }

    @Test
    void case2() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(() -> {
            // 병렬로 실행될 작업
        });
        executor.shutdown();
    }
}
