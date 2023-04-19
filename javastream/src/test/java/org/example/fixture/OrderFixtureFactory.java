package org.example.fixture;

import org.example.models.Order;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.example.models.Order.OrderStatus.CREATED;
import static org.example.models.Order.OrderStatus.ERROR;
import static org.example.models.Order.OrderStatus.IN_PROGRESS;
import static org.example.models.Order.OrderStatus.PROCESSED;

public class OrderFixtureFactory {

    public static List<Order> createOrder() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        return List.of(
            Order.builder()
                .id(1001)
                .status(CREATED)
                .createdAt(now.minusHours(4))
                .createdByUserId(101)
                .build(),
            Order.builder()
                .id(1002)
                .status(ERROR)
                .createdAt(now.minusHours(15))
                .createdByUserId(102)
                .build(),
            Order.builder()
                .id(1003)
                .status(PROCESSED)
                .createdAt(now.minusHours(36))
                .createdByUserId(103)
                .build(),
            Order.builder()
                .id(1004)
                .status(ERROR)
                .createdAt(now.minusHours(2))
                .createdByUserId(104)
                .build(),
            Order.builder()
                .id(1005)
                .status(IN_PROGRESS)
                .createdAt(now.minusHours(10))
                .createdByUserId(105)
                .build()
        );
    }

}
