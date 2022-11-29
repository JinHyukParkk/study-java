package com.example.ddd.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.ddd.calculator.Calculator;
import com.example.ddd.domain.Customer;
import com.example.ddd.repository.CustomerRepository;
import java.math.BigDecimal;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculateDiscountServiceTest {

    @Autowired
    CalculateDiscountService calculateDiscountService;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void noCustomer_thenExceptionShouldBeThrown() {
        CustomerRepository stubRepo = mock(CustomerRepository.class);

        when(stubRepo.findById(1L)).thenReturn(null);

        Calculator calculator = (money) -> null;

        CalculateDiscountService calDisSvc = new CalculateDiscountService(
                stubRepo,
                calculator);

        assertThrows(Exception.class, () -> calDisSvc.calculateDiscount(1L));
    }

    @Test
    public void customer_thenShouldReturnMoney() throws Exception {
        // given
        Customer customer = Customer.builder()
                .name("hyuk")
                .email("pjh0819@naver.com")
                .money(BigDecimal.TEN)
                .build();

        customerRepository.save(customer);

        // when
        Money calculateDiscountedMoney = calculateDiscountService.calculateDiscount(
                customer.getId());

        // then
        assertThat(calculateDiscountedMoney.getNumber().intValue()).isEqualTo(7);
    }
}
