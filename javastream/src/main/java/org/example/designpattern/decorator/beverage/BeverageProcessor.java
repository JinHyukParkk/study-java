package org.example.designpattern.decorator.beverage;

@FunctionalInterface
public interface BeverageProcessor {

    Beverage process(Beverage beverage);

    default BeverageProcessor andThen(BeverageProcessor next) {
        return beverage -> next.process(process(beverage));
    }
}
