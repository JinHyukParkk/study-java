package org.example.designpattern.decorator;

public class DiscountPriceProcessor implements PriceProcessor {

    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + " and discount");
    }
}
