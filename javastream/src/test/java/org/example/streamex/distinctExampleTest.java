package org.example.streamex;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;


class distinctExampleTest {

    @Test
    void case1() {
        List<Integer> numberList = List.of(1, 2, 3, 4, 1, 2, 3, 8, 9, 10);
        List<Integer> distinctList = numberList.stream()
            .distinct()
            .collect(Collectors.toList());

        System.out.println(distinctList);
    }
}
