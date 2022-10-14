package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonServiceTest {

    PersonService personService = new PersonService();

    List<Person> persons = new ArrayList<>();

    @BeforeEach
    void setUp() {
        persons.add(new Person(
                Optional.of(new Car(
                        Optional.of(new Insurance("A"))))));
        persons.add(new Person(
                Optional.of(new Car(
                        Optional.of(new Insurance("B"))))));
        persons.add(new Person(
                Optional.of(new Car(
                        Optional.of(new Insurance("C"))))));
        persons.add(new Person(
                Optional.of(new Car(
                        Optional.of(new Insurance("D"))))));
        persons.add(new Person(
                Optional.of(new Car(
                        Optional.of(new Insurance("A"))))));
    }

    @Test
    void testCarInsurancesNames() {
        personService.getCarInsurancesNames(persons)
                .forEach(System.out::println);
    }



}
