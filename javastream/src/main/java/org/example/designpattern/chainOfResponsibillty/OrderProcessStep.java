package org.example.designpattern.chainOfResponsibillty;

import java.util.Optional;
import java.util.function.Consumer;

public class OrderProcessStep {

    private final Consumer<Order> processOrder;

    private OrderProcessStep next;

    public OrderProcessStep(Consumer<Order> processOrder) {
        this.processOrder = processOrder;
    }

    public OrderProcessStep setNext(OrderProcessStep next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.setNext(next);
        }

        return this;
    }

    public void process(Order order) {
        processOrder.accept(order);

        Optional.ofNullable(next)
            .ifPresent(next -> next.process(order));
    }
}
