package org.example.designpattern.decorator.beverage;

public class Beverage {

    private final String name;
    private final int price;

    public Beverage(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public BeverageProcessor addToping(BeverageProcessor processor) {
        return processor.andThen(processor);
    }

    @Override
    public String toString() {
        return "Beverage{" +
            "name='" + name + '\'' +
            ", price=" + price +
            '}';
    }
}
