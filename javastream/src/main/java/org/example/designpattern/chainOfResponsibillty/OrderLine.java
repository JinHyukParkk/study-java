package org.example.designpattern.chainOfResponsibillty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
public class OrderLine {

    private long id;
    private OrderLineType type;
    private long productId;
    private int quantity;
    private BigDecimal amount;

    public enum OrderLineType {
        PURCHASE, DISCOUNT
    }

    @Builder
    public OrderLine(long id, OrderLineType type, long productId, int quantity, BigDecimal amount) {
        this.id = id;
        this.type = type;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }
}
