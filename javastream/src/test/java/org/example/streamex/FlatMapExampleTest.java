package org.example.streamex;

import org.example.fixture.OrderFixtureFactory;
import org.example.models.Order;
import org.example.models.OrderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FlatMapExampleTest {

    @Test
    @DisplayName("Array -> Stream flatMap 간단 예시")
    void case1() {
        String[][] cities = new String[][]{
            {"Seoul", "Busan"},
            {"New York", "Washington"},
            {"Paris", "Lyon"}
        };

        List<String> cityList = Arrays.stream(cities)
            .flatMap(Stream::of)
            .collect(Collectors.toList());

        System.out.println(cityList);
    }


    @Test
    @DisplayName("List -> Stream flatMap 간단 예시")
    void case2() {
        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );

        List<Integer> flattenedList = listOfLists.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

        System.out.println(flattenedList); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    @Test
    @DisplayName("flatMap을 이용한 Order -> OrderLine 변환")
    void case3() {
        List<Order> orders = OrderFixtureFactory.createOrderWithOrderLine();

        List<OrderLine> orderLineList = orders.stream()
            .flatMap(order -> order.getOrderLines().stream())
            .collect(Collectors.toList());

        System.out.println(orderLineList);
    }

    @Test
    @DisplayName("flatMap을 이용한 Order -> OrderLine 변환 2")
    void case4() {
        List<Order> orders = OrderFixtureFactory.createOrderWithOrderLine();

        List<OrderLine> orderLineList = orders.stream()
            .map(Order::getOrderLines)
            .flatMap(List::stream)
            .collect(Collectors.toList());

        System.out.println(orderLineList);
    }
}
