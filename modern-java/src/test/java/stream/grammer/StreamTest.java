package stream.grammer;

import java.util.Collections;
import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stream.grammer.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

    List<Person> personList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        personList.add(new Person("hyuk", 30, "010-1234-1234"));
        personList.add(new Person("hyuk", 29, "010-1234-4567"));
        personList.add(new Person("jun", 31, "010-5678-5678"));
        personList.add(new Person("jin", 29, "010-1987-0987"));
        personList.add(new Person("chul", 33, "010-1356-1356"));
    }

    @Test
    void listToMap() {
        Map<String, Person> personMap = personList.stream()
                .collect(Collectors.toMap(Person::getName, Function.identity()));

        personMap.forEach((key, value) -> System.out.println(key + " : " + value));

    }

    @Test
    void sort() {
        Collections.sort(personList, Comparator.comparing(Person::getName)
                .thenComparing(Person::getAge));

        personList.forEach(System.out::println);
    }
}
