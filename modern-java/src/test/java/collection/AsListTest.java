package collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class AsListTest {

    @Test
    void listTest() {
        List<String> friends = Arrays.asList("hyuk", "chul", "gun", "min");

        friends.forEach(System.out::println);
    }

    @Test
    void listTest2() {
        List<String> friends = List.of("hyuk", "chul", "gun", "min");

        try {
            System.out.println("friends.add(\"suk\"); // suk 추가");
            friends.add("suk");
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException - '변경'이나 '추가' 할 수 없는 리스트임");
        }


        friends.forEach(System.out::println);
    }

    @Test
    void setTest() {
        Set<String> friends = new HashSet<>(Arrays.asList("hyuk", "chul", "gun", "min", "hyuk"));

        friends.forEach(System.out::println);
    }

    @Test
    void setTest2() {
        Set<String> friends = Stream.of("hyuk", "chul", "gun", "min", "hyuk")
                .collect(Collectors.toSet());

        friends.forEach(System.out::println);
    }
}
