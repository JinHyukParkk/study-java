package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import org.junit.jupiter.api.Test;

class ArrayListExampleTest {

    @Test
    void testDefaultMethodInIterable() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            strings.add(String.format("test %d", i));
        }

        // Iterable 디폴트 메서드 (foreach)
        long startTime = System.nanoTime();

        strings.forEach((i) -> {
        });

        System.out.println((System.nanoTime() - startTime) / 1000000 + "밀리초 걸림");

        // Iterable 디폴트 메서드(spliterator)
        startTime = System.nanoTime();

        Spliterator<String> spliterator = strings.spliterator();
        spliterator.forEachRemaining((i) -> {
        });

        System.out.println((System.nanoTime() - startTime) / 1000000 + "밀리초 걸림");
    }

    @Test
    void removeIfTest() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }

        // removeIf
        numbers.removeIf(i -> i % 2 == 0);

        System.out.println(numbers);
    }
}
