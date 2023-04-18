package org.example.fixture;

import org.example.models.Order;

import java.util.List;

import static org.example.models.Order.OrderStatus.CREATED;
import static org.example.models.Order.OrderStatus.ERROR;
import static org.example.models.Order.OrderStatus.IN_PROGRESS;
import static org.example.models.Order.OrderStatus.PROCESSED;

public class OrderFixtureFactory {

    public static List<Order> createOrder() {
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
