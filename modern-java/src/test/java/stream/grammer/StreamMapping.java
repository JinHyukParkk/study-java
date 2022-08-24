package stream.grammer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamMapping {

    @Test
    void flatTest() {
        List<String> arrayOfWords = Arrays.asList("Goodbye", "World");

//        List<String> words = arrayOfWords.stream()
//                .map(word -> word.split(""))
//                .map(Arrays::stream)
//                .distinct()
//                .collect(toList());
    }

    @Test
    void flatMapTest() {
        List<String> arrayOfWords = Arrays.asList("Goodbye", "World");

        List<String> words = arrayOfWords.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        words.forEach(System.out::println);
    }

    @Test
    @DisplayName("두 리스트 값의 합이 3으로 나누어 떨어지는 쌍으로 반환")
    void flatMapTest2() {
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(4, 5);

        List<int[]> pairs = nums1.stream()
                .flatMap(i -> nums2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(toList());

        pairs.forEach(arr -> System.out.println(arr[0] + ", " + arr[1]));
    }
}
