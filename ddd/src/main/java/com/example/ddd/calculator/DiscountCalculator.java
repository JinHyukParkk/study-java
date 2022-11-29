package com.example.ddd.calculator;

import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;

@Component
public class DiscountCalculator implements Calculator {

    private final static double DISCOUNT_RATE = 0.7;


    public Money calculate(Money money) {

        return money.multiply(DISCOUNT_RATE);
    }
}
