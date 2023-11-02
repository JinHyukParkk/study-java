package async;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorServiceExampleTest {

    @Test
    void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 작업을 제출하여 실행
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                // 간단한 작업 수행
                System.out.println("Task " + taskId + " is running on thread: " + Thread.currentThread().getName());
            });
        }

        // 작업 완료 후 스레드 풀 종료
        executorService.shutdown();


    }
}
