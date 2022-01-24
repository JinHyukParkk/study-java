package lambda;

import org.junit.jupiter.api.Test;

public class lambadThreadTest {

    @Test
    void runnableTest() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Start Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("End Thread");
            }
        });

        Thread thread1 = new Thread(() -> {
            System.out.println("Start Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End Thread");
        });

        thread.start();

        thread1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
