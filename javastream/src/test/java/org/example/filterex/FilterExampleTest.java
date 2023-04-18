package org.example.filterex;

import org.example.fixture.UserFixtureFactory;
import org.example.models.Order;
import org.example.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.models.Order.OrderStatus.CREATED;
import static org.example.models.Order.OrderStatus.ERROR;
import static org.example.models.Order.OrderStatus.IN_PROGRESS;
import static org.example.models.Order.OrderStatus.PROCESSED;

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
        List<User> users = UserFixtureFactory.createUsers();

        List<User> userList = users.stream()
            .filter(User::isVerified)
            .collect(Collectors.toList());

        System.out.println(userList);
    }

    @Test
    @DisplayName("에러 주문만 뽑기 테스트")
    void case3() {
        List<Order> orders = createOrder();

        List<Order> orderList = orders.stream()
            .filter(order -> order.getStatus() == ERROR)
            .collect(Collectors.toList());

        System.out.println(orderList);
    }

    private List<Order> createOrder() {
        return List.of(
            Order.builder()
                .id(1001)
                .status(CREATED)
                .build(),
            Order.builder()
                .id(1002)
                .status(ERROR)
                .build(),
            Order.builder()
                .id(1003)
                .status(PROCESSED)
                .build(),
            Order.builder()
                .id(1004)
                .status(ERROR)
                .build(),
            Order.builder()
                .id(1005)
                .status(IN_PROGRESS)
                .build()
        );
    }
}
