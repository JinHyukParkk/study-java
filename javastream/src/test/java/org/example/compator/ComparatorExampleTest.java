package org.example.compator;

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
        users.add(new User(3, "Hyuk"));
        users.add(new User(1, "Min"));
        users.add(new User(5, "Gun"));

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
