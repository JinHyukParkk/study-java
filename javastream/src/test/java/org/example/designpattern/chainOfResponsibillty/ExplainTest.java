package org.example.designpattern.chainOfResponsibillty;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

class ExplainTest {

    @Test
    void case1() {
        OrderProcessStep initialStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.CREATED) {
                System.out.println("initialStep order id : " + order.getId());
                order.setStatus(Order.OrderStatus.IN_PROGRESS);
            }
        });

        OrderProcessStep validateStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("validateStep order id : " + order.getId());
                order.setAmount(order.getOrderLines().stream()
                    .map(OrderLine::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add));
            }
        });

        OrderProcessStep verifyStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("verifyStep order id : " + order.getId());
                if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                    order.setStatus(Order.OrderStatus.ERROR);
                }
            }
        });

        OrderProcessStep processStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("processStep order id : " + order.getId());
                // 뭔가 실행
                order.setStatus(Order.OrderStatus.PROCESSED);
            }
        });

        OrderProcessStep handleStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.ERROR) {
                System.out.println("handleStep order id : " + order.getId());
            }
        });

        OrderProcessStep completeStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.PROCESSED) {
                System.out.println("completeStep order id : " + order.getId());
            }
        });

        OrderProcessStep chainOrderProcessSteps = initialStep.setNext(validateStep)
            .setNext(verifyStep)
            .setNext(processStep)
            .setNext(handleStep)
            .setNext(completeStep);

        Order order = Order.builder()
            .id(1001L)
            .status(Order.OrderStatus.CREATED)
            .orderLines(Arrays.asList(OrderLine.builder()
                    .amount(BigDecimal.valueOf(1000))
                    .build(),
                OrderLine.builder()
                    .amount(BigDecimal.valueOf(2000))
                    .build()))
            .build();

        chainOrderProcessSteps.process(order);
    }
}
