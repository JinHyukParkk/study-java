package org.example.designpattern.decorator.price;

public class TaxPriceProcessor implements PriceProcessor {

    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + " and tax");
    }
}
