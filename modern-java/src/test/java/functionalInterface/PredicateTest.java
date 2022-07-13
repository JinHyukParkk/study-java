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
    }

    @Test
    void test() {
        Predicate<Integer> integerPredicate = i -> i > 10;

        List<Integer> afterList = intList.stream().filter(integerPredicate).collect(Collectors.toList());

        afterList.forEach(System.out::println);
    }
}
