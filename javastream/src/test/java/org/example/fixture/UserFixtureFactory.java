package org.example.fixture;

import org.example.models.User;

import java.util.List;

public class UserFixtureFactory {

    public static List<User> createUsers() {
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
                .build(),
            User.builder()
                .id(105)
                .name("suk")
                .isVerified(true)
                .build()
        );
    }

}
