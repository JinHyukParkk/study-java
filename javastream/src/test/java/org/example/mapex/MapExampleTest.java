package org.example.mapex;

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
        List<User> users = createUsers();
        List<String> emailList = users.stream()
            .map(User::getEmailAddress)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
        System.out.println(emailList);
    }

    private List<User> createUsers() {
        return List.of(
            User.builder()
                .id(101)
                .name("hyuk")
                .isVerified(true)
                .emailAddress("hyuk@test.com")
                .friendUserIds(List.of(102, 103, 104))
                .build(),
            User.builder()
                .id(102)
                .name("gun")
                .isVerified(false)
                .build(),
            User.builder()
                .id(103)
                .name("chul")
                .isVerified(false)
                .build(),
            User.builder()
                .id(104)
                .name("min")
                .isVerified(true)
                .emailAddress("min@test.com")
                .build()
        );
    }
}
