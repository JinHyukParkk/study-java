package com.example.ddd.calculator;

import com.example.ddd.domain.Customer;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;

@Component
public class DiscountCalculator {

    private final static double DISCOUNT_RATE = 0.7;


    public Money calculate(Customer customer) {

        Money customerMoney = customer.getMoney();

        return customerMoney.multiply(0.7);
    }
}
