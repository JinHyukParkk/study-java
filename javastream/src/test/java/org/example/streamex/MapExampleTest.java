package org.example.streamex;

import org.example.fixture.UserFixtureFactory;
import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class MapExampleTest {

    @Test
    void case1() {
        List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numberList2 = numberList.stream()
            .map(number -> number * 2)
            .collect(Collectors.toList());
        System.out.println(numberList2);
    }

    @Test
    void case2() {
        List<String> stringList = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        List<String> numberList = stringList.stream()
            .map(x -> "number: " + x)
            .collect(Collectors.toList());
        System.out.println(numberList);
    }

    @Test
    void case3() {
        List<User> users = UserFixtureFactory.createUsers();
        List<String> emailList = users.stream()
            .map(User::getEmailAddress)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
        System.out.println(emailList);
    }
}
