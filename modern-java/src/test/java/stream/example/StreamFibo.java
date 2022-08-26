package stream.example;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamFibo {

    @Test
    void fibo_basic() {
        long time1 = System.nanoTime();
        int n = 5;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        long time2 = System.nanoTime();

        System.out.println(dp[n]);
        System.out.println((time2-time1)/1000.0);
    }

    @Test
    void fibo_stream() {
        long time1 = System.nanoTime();
        int n = 5;
        Optional<Long> answer = Stream.iterate(new long[]{0, 1},
                        t -> new long[]{t[1], t[0] + t[1]})
                .limit(n)
                .map(t -> t[1])
                .reduce((l1, l2) -> l1 < l2 ? l2 : l1);

        long time2 = System.nanoTime();

        System.out.println(answer.get());
        System.out.println((time2-time1)/1000.0);
    }
}
