package functionalInterface;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {
    List<Integer> intList;

    @BeforeEach
    void setUp() {
        intList = new ArrayList<>();
        intList.add(1);
        intList.add(5);
        intList.add(11);
        intList.add(15);
        intList.add(21);
        intList.add(25);
        intList.add(31);
    }

    @Test
    void test() {
        Predicate<Integer> integerPredicate = i -> i > 10;

        List<Integer> afterList = intList.stream().filter(integerPredicate).collect(Collectors.toList());

        afterList.forEach(System.out::println);
    }

    @Test
    void testPredicateAnd() {
        Predicate<Integer> predicate1 = num -> num > 10;
        Predicate<Integer> predicate2 = num -> num < 20;

        List<Integer> afterList = intList.stream().filter(predicate1.and(predicate2)).collect(Collectors.toList());

        afterList.forEach(System.out::println);
    }
}
