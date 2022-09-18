package stream;

import java.util.ArrayList;
import java.util.List;

public class MersennePrime {

    public static List<Integer> execute(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (isPrime(number)) {
                result.add(number);
            }
        }

        return result;
    }

    public static boolean isPrime(int n) {
        int q;
        boolean chk = true;

        for (int i = 2; i < n; i++) {
            q = n % i;

            if (q == 0) {
                chk = false;
                break;
            } else {
                chk = true;
            }
        }

        return chk;
    }

}
