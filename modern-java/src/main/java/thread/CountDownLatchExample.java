package thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class CountDownLatchExample {

    private final static int THREADS = 10;

    private static CountDownLatch latch = new CountDownLatch(THREADS);

    Logger logger = LoggerFactory.getLogger(CountDownLatchExample.class);

    void start() {
        for (int i = 0; i < 10; ++i) {
            new Thread(new RandomSleepRunnable(i)).start();
        }

        try {
            // latch의 카운트가 0이 될 때까지 대기한다.
            latch.await();

            // 2000ms 동안 latch의 카운트가 0되지 않으면 wait 해제
//            latch.await(2000, TimeUnit.MILLISECONDS);

        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }

        System.out.println("All threads terminated");
    }

    public static class RandomSleepRunnable implements Runnable {

        private int id = 0;

        //        private static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        private static Random random = new Random(System.currentTimeMillis());

        Logger logger = LoggerFactory.getLogger(RandomSleepRunnable.class);

        public RandomSleepRunnable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Thread(" + id + ") : Start.");

            int delay = random.nextInt(1001) + 1000;

            try {
                System.out.println("Thread(" + id + ") : Sleep " + delay + "ms");
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
            System.out.println("Thread(" + id + ") : End");
            latch.countDown();
        }
    }
}
