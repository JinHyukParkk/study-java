package org.example.streamex;

import org.example.fixture.OrderFixtureFactory;
import org.example.models.Order;
import org.example.models.OrderLine;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FlatMapExampleTest {

    @Test
    void case1() {
        String[][] cities = new String[][]{
            {"Seoul", "Busan"},
            {"New York", "Washington"},
            {"Paris", "Lyon"}
        };

        List<String> cityList = Arrays.stream(cities)
            .flatMap(city -> List.of(city).stream())
            .collect(Collectors.toList());

        System.out.println(cityList);
    }

    @Test
    void case2() {
        List<Order> orders = OrderFixtureFactory.createOrderWithOrderLine();

        List<OrderLine> orderLineList = orders.stream()
            .flatMap(order -> order.getOrderLines().stream())
            .collect(Collectors.toList());

        System.out.println(orderLineList);
    }
}
