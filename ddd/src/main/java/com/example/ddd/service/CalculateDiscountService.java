package com.example.ddd.service;

import com.example.ddd.calculator.DiscountCalculator;
import com.example.ddd.domain.Customer;
import com.example.ddd.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculateDiscountService {

    private final CustomerRepository customerRepository;
    private final DiscountCalculator discountCalculator;


    public Money CalculateDiscount(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);

        return discountCalculator.calculate(customer);

    }
}
