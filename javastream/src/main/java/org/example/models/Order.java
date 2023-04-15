package org.example.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private long id;
    private LocalDateTime createdAt;
    private OrderStatus status;
    private BigDecimal amount;
    private List<OrderLine> orderLines;

    private enum OrderStatus {
        CREATED, IN_PROGRESS, ERROR, PROCESSED
    }
}
