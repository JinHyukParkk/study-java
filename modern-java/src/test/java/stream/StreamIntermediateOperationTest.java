package stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntermediateOperationTest {

    @Test
    @DisplayName("스트림 필터링")
    void filteringTest() {
        IntStream stream1 = IntStream.of(4,2,3,4,1,3,6,1,2,3,4);
        IntStream stream2 = IntStream.of(4,2,3,4,1,3,6,1,2,3,4);

        // 스트림에서 중복된 요소 제거
        stream1.distinct().forEach(System.out::println);
        System.out.println();

        // 스트림에서 홀수만 골라냄
        stream2.filter(n -> n % 2 != 0).forEach(System.out::println);
    }

    @Test
    @DisplayName("스트림 변환")
    void conversionTest() {
        Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
        stream.map(s -> s.length()).forEach(System.out::println);


        // 문자열을 스트림으로 변환함
        String[] arr = {"I study hard", "You study Java", "I am strong"};

        Stream<String> stream1 = Arrays.stream(arr);
        stream1.flatMap(s -> Stream.of(s.split(" +"))).forEach(System.out::println);
    }

    @Test
    @DisplayName("스트림 제한")
    void limitTest() {
        IntStream stream = IntStream.range(0, 10);
        IntStream stream1 = IntStream.range(0, 10);
        IntStream stream2 = IntStream.range(0, 10);

        stream.skip(4).forEach(n -> System.out.print(n + " "));
        System.out.println();

        stream1.limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        stream2.skip(3).limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    @Test
    @DisplayName("스트림 정렬")
    void sortTest() {
        Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
        Stream<String> stream1 = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");

        stream.sorted().forEach(s -> System.out.print(s + " "));
        System.out.println();

        stream1.sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s + " "));
    }

    @Test
    @DisplayName("스트림 연산 결과 확인")
    void intermediateOperationTest() {
        IntStream stream = IntStream.of(3, 2, 6, 7, 9, 3, 4, 2, 1, 7);

        stream.peek(s -> System.out.println("원본 스트림 : " + s))
                .skip(2)
                .peek(s -> System.out.println("skip(2) 실행 후 : " + s))
                .limit(5)
                .peek(s -> System.out.println("limit(5) 실행 후 : " + s))
                .sorted()
                .peek(s -> System.out.println("sorted() 실행 후 : " + s))
                .forEach(n -> System.out.println(n));
    }
}
