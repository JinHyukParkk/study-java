package org.example.designpattern.decorator;

import org.junit.jupiter.api.Test;

class PriceServiceTest {

    @Test
    void decoTest() {
        Price unprocessedPrice = new Price("Original price");

        PriceProcessor priceProcessor = new BasicPriceProcessor();
        DiscountPriceProcessor discountPriceProcessor = new DiscountPriceProcessor();
        TaxPriceProcessor taxPriceProcessor = new TaxPriceProcessor();

        Price processedPrice = priceProcessor
            .andThen(discountPriceProcessor)
            .andThen(taxPriceProcessor)
            .process(unprocessedPrice);

        System.out.println(processedPrice);
    }


    @Test
    void decoTestWithFunctionalInterface() {
        Price unprocessedPrice = new Price("Original price");

        PriceProcessor priceProcessor = new BasicPriceProcessor();
        PriceProcessor discountPriceProcessor = price -> new Price(price.getPrice() + " and discount");
        PriceProcessor taxPriceProcessor = price -> new Price(price.getPrice() + " and tax");

        Price processedPrice = priceProcessor
            .andThen(discountPriceProcessor)
            .andThen(taxPriceProcessor)
            .process(unprocessedPrice);

        System.out.println(processedPrice);
    }
}
