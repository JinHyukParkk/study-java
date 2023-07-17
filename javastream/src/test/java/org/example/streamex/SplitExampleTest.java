package org.example.streamex;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;
import java.util.stream.Stream;

class SplitExampleTest {

    @Test
    void case1() {
        Stream<String> stream = Pattern.compile(",")
            .splitAsStream("Apple,Banana,Melon");

        stream.forEach(System.out::println);
    }
}
