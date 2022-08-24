package stream.grammer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamListTest {

    @Test
    @DisplayName("컬렉션 - 스트림 테스트")
    void listTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(9);
        list.add(7);

        // 컬렉션에서 Stream 생성
        Stream<Integer> stream = list.stream();

        // forEach() 메소드를 이용한 스트림 요소의 순차 접근
        stream.forEach(System.out::println);
    }

    @Test
    @DisplayName("배열 - 스트림 테스트")
    void arrayTest() {
        String[] arr = new String[]{"하나", "둘", "셋", "넷"};

        // 배열에서 스트림 생성
        Stream<String> streamArr = Arrays.stream(arr);
        streamArr.forEach(System.out::println);
        System.out.println();
        
        // 배열의 특정 부분만을 이용한 스트림 생성
        Stream<String> streamArr1 = Arrays.stream(arr, 1, 3);
        streamArr1.forEach(System.out::println);
    }

    @Test
    @DisplayName("IntStream 테스트")
    void intStreamTest() {
        IntStream intStream = IntStream.range(1, 4);
        intStream.forEach(System.out::println);
        System.out.println();

        IntStream intStream1 = IntStream.rangeClosed(1, 4);
        intStream1.forEach(System.out::println);
    }

    @Test
    @DisplayName("Random - IntStream 테스트")
    void intStreamOfRandom() {
        IntStream stream = new Random().ints(4);
        stream.forEach(System.out::println);
    }
}
