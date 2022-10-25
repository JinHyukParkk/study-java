package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExampleExecutor2 {

    public void execute() {
        final int maxCore = Runtime.getRuntime().availableProcessors();
        System.out.println("Max Core : " + maxCore);

        final ExecutorService executorService = Executors.newFixedThreadPool(maxCore);
        final List<Future<String>> futureList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            final int index = i;
            futureList.add(executorService.submit(() -> {
                System.out.println("finished job" + index);
                return "job" + index + " " + Thread.currentThread().getName();
            }));
        }

        for (Future<String> future : futureList) {
            String result = null;
            try {
                result = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }

        executorService.shutdownNow();
        System.out.println("end");
    }
}
