package org.example.optionalex;

import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class OptionalExampleTest {

    @Test
    void case1() {
        User user1 = User.builder()
            .id(1001)
            .name("hyuk")
            .isVerified(false)
            .build();

        String defaultEmail = "default@naver.com";
        String hyukEmail = Optional.ofNullable(user1.getEmailAddress()).orElse(defaultEmail);
        System.out.println(hyukEmail);
    }

    @Test
    void case2() {
        User user1 = User.builder()
            .id(1001)
            .name("hyuk")
            .isVerified(false)
            .build();

        User user2 = User.builder()
            .id(1002)
            .name("hyuk")
            .isVerified(true)
            .build();

        System.out.println(userEquals(user1, user2));
        System.out.println(userEquals(user1, user1));

    }

    @Test
    void case3() {
        Optional<User> maybeUser = Optional.ofNullable(getMaybeUser(false));
        maybeUser.ifPresent(user -> System.out.println(user.getName()));
        System.out.println("아무것도 출력되지 않아야 함");
    }

    @Test
    void case3_1() {
        Optional<User> maybeUser = Optional.ofNullable(getMaybeUser(true));
        maybeUser.ifPresent(user -> System.out.println(user.getName()));
    }

    private static User getMaybeUser(boolean returnUser) {
        if (returnUser) {
            return User.builder()
                .id(1001)
                .name("hyuk")
                .isVerified(false)
                .build();
        }

        return null;
    }

    public static boolean userEquals(User user1, User user2) {
        return Optional.ofNullable(user1)
            .map(user -> user.equals(user2))
            .orElse(false);
    }
}
