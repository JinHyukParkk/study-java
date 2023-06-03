package org.example.streamex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PartitioningByExampleTest {

    @Test
    @DisplayName("조건에 따라 분류한다")
    void case1() {
        List<Integer> numbers = List.of(123, 524, 342, 125, 64, 3, 234, 478, 345, 27, 8, 564);
        Map<Boolean, List<Integer>> unitDigitToNumbersMap = numbers.stream()
            .collect(Collectors.partitioningBy(number -> number % 2 == 0));

        System.out.println(unitDigitToNumbersMap);
    }
}
