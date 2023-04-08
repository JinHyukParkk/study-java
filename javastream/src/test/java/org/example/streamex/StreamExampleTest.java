package org.example.streamex;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamExampleTest {

    @Test
    void case1() {
        Stream<String> nameStream = Stream.of("John", "Jane", "Jenny", "Jack");
        List<String> names = nameStream.collect(Collectors.toList());
        names.forEach(System.out::println);

        System.out.println("=====================================");

        String[] cityArray = new String[]{"Seoul", "Busan", "Incheon", "Daegu"};
        Stream<String> cityStream = Stream.of(cityArray);
        List<String> cities = cityStream.collect(Collectors.toList());
        cities.forEach(System.out::println);

        System.out.println("=====================================");

        Set<Integer> numberSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Stream<Integer> numberStream = numberSet.stream();
        List<Integer> numbers = numberStream.collect(Collectors.toList());
        numbers.forEach(System.out::println);
    }
}
