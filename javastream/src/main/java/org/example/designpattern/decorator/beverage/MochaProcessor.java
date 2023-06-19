package org.example.designpattern.decorator.beverage;

public class MochaProcessor implements BeverageProcessor {

    private static final int MOCHA_PRICE = 500;

    @Override
    public Beverage process(Beverage beverage) {
        return new Beverage(beverage.getName() + " and mocha", beverage.getPrice() + MOCHA_PRICE);
    }
}
