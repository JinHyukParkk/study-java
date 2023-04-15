package org.example.filterex;

import org.example.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FilterExampleTest {

    @Test
    @DisplayName("Filter Basic Example")
    void case1() {
        // given
        Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // when
        List<Integer> evenList = numberStream.filter(number -> number % 2 == 0)
            .collect(Collectors.toList());

        // then
        System.out.println(evenList);
    }

    @Test
    @DisplayName("이메일 검증된 유저만 뽑기 테스트")
    void case2() {
        List<User> users = createUsers();

        List<User> userList = users.stream()
            .filter(User::isVerified)
            .collect(Collectors.toList());

        System.out.println(userList);
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
