package stream.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stream.grammer.model.Person;

public class ParallelTest {

    List<Person> personList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        personList.add(new Person("hyuk", 30, "010-1234-1234"));
        personList.add(new Person("jun", 31, "010-5678-5678"));
        personList.add(new Person("jin", 29, "010-1987-0987"));
        personList.add(new Person("chul", 33, "010-1356-1356"));
    }
    @Test
    void test() {
        personList.parallelStream()
                .filter(d -> d.getAge() > 30)
                .map(Person::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
