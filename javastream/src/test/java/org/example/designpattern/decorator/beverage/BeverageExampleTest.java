package org.example.designpattern.decorator.beverage;

import org.junit.jupiter.api.Test;

class BeverageExampleTest {

    @Test
    void decoTest() {
        Beverage espresso = new Espresso();

        BeverageProcessor mochaProcessor = new MochaProcessor();
        BeverageProcessor whipProcessor = new WhipProcessor();

        Beverage decoEspresso = mochaProcessor.andThen(whipProcessor).process(espresso);

        System.out.println(decoEspresso);
    }

    @Test
    void decoTestWithLambda() {
        Beverage espresso = new Espresso();

        BeverageProcessor mochaProcessor = beverage -> new Beverage(beverage.getName() + " and mocha", beverage.getPrice() + 500);
        BeverageProcessor whipProcessor = beverage -> new Beverage(beverage.getName() + " and whip", beverage.getPrice() + 300);

        Beverage decoEspresso = mochaProcessor.andThen(whipProcessor).process(espresso);

        System.out.println(decoEspresso);
    }
}
