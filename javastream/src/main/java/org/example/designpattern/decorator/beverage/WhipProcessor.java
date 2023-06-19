package org.example.designpattern.decorator.beverage;

public class WhipProcessor implements BeverageProcessor {

    private static final int WHIP_PRICE = 300;

    @Override
    public Beverage process(Beverage beverage) {
        return new Beverage(beverage.getName() + " and whip", beverage.getPrice() + WHIP_PRICE);
    }
}
