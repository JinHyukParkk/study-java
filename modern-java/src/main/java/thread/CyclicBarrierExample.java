package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class CyclicBarrierExample {

    private final static int THREADS = 5;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS);

    void start() {
        for (int i = 0; i < THREADS; ++i) {
            new Thread(new RandomSleepRunnable(i)).start();
        }
    }

    public static class RandomSleepRunnable implements Runnable {

        private int id = 0;

        private static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        public RandomSleepRunnable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Thread(" + id + ") : Start.");
            // 1000ms 에서 2000ms 사이의 딜레이 값을 랜덤하게 생성
            int delay = threadLocalRandom.nextInt(1001) + 1000;

            try {
                System.out.println("Thread(" + id + ") : Sleep " + delay + "ms");

                Thread.sleep(delay);
                System.out.println("Thread(" + id + ") : End Sleep");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                // 대기. cyclicBarrier 를 생성할 때, 인자값으로 준 count 개수만큼
                // await를 호출한다면 모든 쓰레드의 wait 상태가 종료된다.
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("Thread(" + id + ") : End.");
        }
    }
}
