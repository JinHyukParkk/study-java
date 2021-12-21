package stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTerminalOperationTest {

    @Test
    @DisplayName("요소의 출력")
    void streamFor() {
        Stream<String> stream = Stream.of("넷", "둘", "셋", "하나");
        stream.forEach(System.out::println);
    }

    @Test
    @DisplayName("요소의 소모")
    void streamReduce() {
        Stream<String> stream = Stream.of("넷", "둘", "셋", "하나");
        Stream<String> stream1 = Stream.of("넷", "둘", "셋", "하나");

        Optional<String> result1 = stream.reduce((s1, s2) -> s1 + "++" + s2);
        result1.ifPresent(System.out::println);

        String result2 = stream1.reduce("시작", (s1, s2) -> s1 + "++" + s2);
        System.out.println(result2);
    }

    @Test
    @DisplayName("요소의 검색")
    void streamSearch() {
        IntStream stream1 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
        IntStream stream2 = IntStream.of(4, 2, 7, 3, 5, 1, 6);

        OptionalInt result1 = stream1.sorted().findFirst();
        System.out.println(result1.getAsInt());

        OptionalInt result2 = stream2.sorted().findAny();
        System.out.println(result2.getAsInt());
    }

    @Test
    @DisplayName("요소의 검사")
    void streamMatch() {
        IntStream stream1 = IntStream.of(30, 90, 70, 10);
        IntStream stream2 = IntStream.of(30, 90, 70, 10);

        System.out.println(stream1.anyMatch(n -> n > 80));
        System.out.println(stream2.allMatch(n -> n > 80));
    }

    @Test
    @DisplayName("요소의 통계")
    void streamStatic() {
        IntStream stream1 = IntStream.of(30, 90, 70, 10);
        IntStream stream2 = IntStream.of(30, 90, 70, 10);
        IntStream stream3 = IntStream.of(30, 90, 70, 10);

        System.out.println(stream1.count());
        System.out.println(stream2.max().getAsInt());
        System.out.println(stream3.min().getAsInt());
    }

    @Test
    @DisplayName("요소의 연산")
    void streamOperation() {
        IntStream stream1 = IntStream.of(30, 90, 70, 10);
        DoubleStream stream2 = DoubleStream.of(30.3, 90.9, 70.7, 10.1);

        System.out.println(stream1.sum());
        System.out.println(stream2.average().getAsDouble());
    }

    @Test
    @DisplayName("요소의 수집")
    void streamCollect() {
        Stream<String> stream = Stream.of("넷", "둘", "하나", "셋");

        List<String> list = stream.collect(Collectors.toList());
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }

        Stream<String> stream1 = Stream.of("HTML", "CSS", "JAVA", "PHP");

        Map<Boolean, List<String>> partition = stream1.collect(Collectors.partitioningBy(s -> (s.length() % 2) == 0));

        List<String> oddLengthList = partition.get(false);
        System.out.println(oddLengthList);

        List<String> evenLengthList = partition.get(true);
        System.out.println(evenLengthList);
    }
}
