package org.example.compator;

import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ComparatorExampleTest {

    /*
     * 음수면 o1 < o2
     * 0 이면 o1 = o2
     * 양수면 o1 > o2
     * */
    @Test
    void test() {
        List<User> users = new ArrayList<>();
        users.add(User.builder()
            .id(3)
            .name("Hyuk").build());
        users.add(User.builder()
            .id(1)
            .name("Min").build());
        users.add(User.builder()
            .id(5)
            .name("Gun").build());

        System.out.println(users);

//        Comparator<User> idComparator = (User u1, User u2) -> u1.getId() - u2.getId();
        Comparator<User> idComparator = Comparator.comparingInt(User::getId);
        users.sort(idComparator);
        System.out.println(users);

//        Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        users.sort(Comparator.comparing(User::getName));
        System.out.println(users);
    }
}
