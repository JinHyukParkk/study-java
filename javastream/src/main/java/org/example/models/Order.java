package org.example.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@Getter
public class Order {

    private long id;
    private LocalDateTime createdAt;
    private OrderStatus status;
    private BigDecimal amount;
    private List<OrderLine> orderLines;

    public enum OrderStatus {
        CREATED, IN_PROGRESS, ERROR, PROCESSED
    }

    @Builder
    public Order(long id, LocalDateTime createdAt, OrderStatus status, BigDecimal amount, List<OrderLine> orderLines) {
        this.id = id;
        this.createdAt = createdAt;
        this.status = status;
        this.amount = amount;
        this.orderLines = orderLines;
    }
}
