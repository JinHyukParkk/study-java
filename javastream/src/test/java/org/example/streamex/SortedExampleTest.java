package org.example.streamex;

import org.example.fixture.OrderFixtureFactory;
import org.example.fixture.UserFixtureFactory;
import org.example.models.Order;
import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class SortedExampleTest {

    @Test
    void case1() {
        List<Integer> numbers = Arrays.asList(3, -5, 7, 4);
        List<Integer> sortedNumbers = numbers.stream()
            .sorted()
            .collect(Collectors.toList());

        System.out.println(sortedNumbers);
    }

    @Test
    void case2() {
        List<User> users = UserFixtureFactory.createUsers();
        List<String> sortedUsers = users.stream()
//            .sorted((user1, user2) -> user1.getName().compareTo(user2.getName()))
            .sorted(Comparator.comparing(User::getName))
            .map(User::getName)
            .collect(Collectors.toList());

        System.out.println(sortedUsers);
    }

    @Test
    void case3() {
        List<Order> orders = OrderFixtureFactory.createOrder();
        List<Long> sortedOrders = orders.stream()
            .sorted(Comparator.comparing(Order::getCreatedAt))
            .map(Order::getId)
            .collect(Collectors.toList());

        System.out.println(sortedOrders);
    }
}
