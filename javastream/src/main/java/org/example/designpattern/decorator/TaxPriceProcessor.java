package org.example.designpattern.decorator;

public class TaxPriceProcessor implements PriceProcessor {

    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + " and tax");
    }
}
