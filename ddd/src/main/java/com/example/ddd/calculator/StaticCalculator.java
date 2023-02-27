package com.example.ddd.calculator;

import org.javamoney.moneta.Money;

public class StaticCalculator implements Calculator {
    @Override
    public Money calculate(Money money) {
        return money.plus();
    }
}
