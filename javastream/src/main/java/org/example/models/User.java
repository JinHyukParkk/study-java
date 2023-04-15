package org.example.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private List<Integer> friendUserIds;

    @Builder
    public User(int id, String name, String emailAddress, boolean isVerified, List<Integer> friendUserIds) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.isVerified = isVerified;
        this.friendUserIds = friendUserIds;
    }
}
