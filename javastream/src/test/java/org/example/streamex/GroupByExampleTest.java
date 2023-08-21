package org.example.streamex;

import org.example.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class GroupByExampleTest {


    @Test
    void case1() {
        List<Integer> numbers = List.of(123, 524, 342, 125, 64, 3, 234, 478, 345, 27, 8, 564);
        Map<Integer, List<Integer>> unitDigitToNumbersMap = numbers.stream()
            .collect(Collectors.groupingBy(number -> number % 10));
        System.out.println(unitDigitToNumbersMap);
    }

    @Test
    void case2() {
        List<Integer> numbers = List.of(123, 524, 342, 125, 64, 3, 234, 478, 345, 27, 8, 564, 123, 523, 125, 64, 3, 234, 478, 111);
        Map<Integer, Set<Integer>> unitDigitToNumbersMap = numbers.stream()
            .collect(Collectors.groupingBy(number -> number % 10, Collectors.toSet()));
        System.out.println(unitDigitToNumbersMap);
    }

    @Test
    void case3() {
        List<Integer> numbers = List.of(123, 524, 342, 125, 64, 3, 234, 478, 345, 27, 8, 564, 123, 523, 125, 64, 3, 234, 478, 111);
        Map<Integer, Long> unitDigitToNumbersMap = numbers.stream()
            .collect(Collectors.groupingBy(number -> number % 10, Collectors.counting()));
        System.out.println(unitDigitToNumbersMap);
    }

    @Test
    void case4() {
        List<Integer> numbers = List.of(123, 524, 342, 125, 64, 3, 234, 478, 345, 27, 8, 564, 123, 523, 125, 64, 3, 234, 478, 111);
        Map<Integer, List<String>> unitDigitToNumbersMap = numbers.stream()
            .collect(Collectors.groupingBy(number -> number % 10, Collectors.mapping(number -> "value : " + number, Collectors.toList())));
        System.out.println(unitDigitToNumbersMap);
    }

    @Test
    void case5() {
        List<Person> people = Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 25),
            new Person("David", 30)
        );

        // Group people by age
        Map<Integer, List<Person>> peopleByAge = people.stream()
            .collect(Collectors.groupingBy(Person::getAge));

        // Print the grouped result
        peopleByAge.forEach((age, persons) -> {
            System.out.println("Age: " + age);
            persons.forEach(person -> System.out.println("  " + person.getName()));
        });
    }
}
