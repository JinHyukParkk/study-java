package org.example.models;

import java.math.BigDecimal;

public class OrderLine {

    private long id;
    private OrderLineType type;
    private long productId;
    private int quantity;
    private BigDecimal amount;

    private enum OrderLineType {
        PURCHASE, DISCOUNT
    }

    public OrderLine(long id, OrderLineType type, long productId, int quantity, BigDecimal amount) {
        this.id = id;
        this.type = type;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public OrderLineType getType() {
        return type;
    }

    public long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
