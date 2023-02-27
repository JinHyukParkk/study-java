package com.example.ddd.service;

import com.example.ddd.calculator.Calculator;
import com.example.ddd.domain.Customer;
import com.example.ddd.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountCalculateService {

    private final CustomerRepository customerRepository;

    private final Calculator discountCalculator;

    public Money calculateDiscount(Long customerId) throws Exception {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new Exception("no customer"));

        Money customerMoney = Money.of(customer.getMoney(), "USD");

        return discountCalculator.calculate(customerMoney);
    }
}
