package org.example.streamex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PartitioningByExampleTest {

    @Test
    @DisplayName("홀수 짝수, 조건에 따라 분류한다")
    void case1() {
        List<Integer> numbers = List.of(123, 524, 342, 125, 64, 3, 234, 478, 345, 27, 8, 564);
        Map<Boolean, List<Integer>> unitDigitToNumbersMap = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));

        System.out.println(unitDigitToNumbersMap);
    }

    @Test
    @DisplayName("소수 조건에 따라 분류한다")
    void case2() {
        List<Integer> numbers = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(this::isPrime));

        List<Integer> primeNumbers = partitioned.get(true);
        List<Integer> notPrimeNumbers = partitioned.get(false);

        System.out.println("소수: " + primeNumbers);
        System.out.println("소수 아닌 수: " + notPrimeNumbers);
    }

    private boolean isPrime(int number) {
        return number > 1 && java.util.stream.IntStream.range(2, number).noneMatch(index -> number % index == 0);
    }
}
