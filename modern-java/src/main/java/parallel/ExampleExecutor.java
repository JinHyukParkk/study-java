package parallel;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExampleExecutor {

    public void execute() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Job1 : " + threadName);
        });

        executorService.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Job2 : " + threadName);
        });

        executorService.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Job3 : " + threadName);
        });

        // 3초 지연
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String threadName = Thread.currentThread().getName();
            System.out.println("Job4 : " + threadName);
        });

        // 더 이상 ExecutorService에 Task를 추가할 수 없음
        // 작업이 모두 완료되면 쓰레드풀을 종료
        executorService.shutdown();

        // shutdown() 호출 전에 등록된 Task 중 아직 완료되지 않은 Task가 있을 수 있음
        // Timeout을 2초 설정하고 완료되기를 기다림
        // 20초 전에 완료되면 true를 리턴하며, 2초가 지나도 완료되지 않으면 false를 리턴함
        if (executorService.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println(LocalTime.now() + " All jobs are terminated");
        } else {
            System.out.println(LocalTime.now() + " some jobs are not terminated");

            // 모든 Task를 강제 종료함
            executorService.shutdownNow();
        }

        System.out.println("end");
    }
}
