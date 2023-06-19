package org.example.designpattern.decorator.price;

public class DiscountPriceProcessor implements PriceProcessor {

    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + " and discount");
    }
}
