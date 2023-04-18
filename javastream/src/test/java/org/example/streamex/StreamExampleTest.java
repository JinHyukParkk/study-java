package org.example.streamex;

import org.example.fixture.OrderFixtureFactory;
import org.example.fixture.UserFixtureFactory;
import org.example.models.Order;
import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamExampleTest {

    @Test
    void case1() {
        Stream<String> nameStream = Stream.of("John", "Jane", "Jenny", "Jack");
        List<String> names = nameStream.collect(Collectors.toList());
        names.forEach(System.out::println);

        System.out.println("=====================================");

        String[] cityArray = new String[]{"Seoul", "Busan", "Incheon", "Daegu"};
        Stream<String> cityStream = Stream.of(cityArray);
        List<String> cities = cityStream.collect(Collectors.toList());
        cities.forEach(System.out::println);

        System.out.println("=====================================");

        Set<Integer> numberSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Stream<Integer> numberStream = numberSet.stream();
        List<Integer> numbers = numberStream.collect(Collectors.toList());
        numbers.forEach(System.out::println);
    }

    @Test
    void case2() {
        List<String> emailList = UserFixtureFactory.createUsers().stream()
            .filter(user -> user.isVerified())
            .map(User::getEmailAddress)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        System.out.println(emailList);
    }

    @Test
    void case3() {
        List<Order> userIds = OrderFixtureFactory.createOrder().stream()
            .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
//            .map(Order::getCreatedByUserId)
            .collect(Collectors.toList());

        System.out.println(userIds);
    }
}
