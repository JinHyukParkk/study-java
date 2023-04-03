package org.example.models;

public class Sedan extends Car {

    public Sedan(String name, String brand) {
        super(name, brand);
    }

    @Override
    public void drive() {
        System.out.println("?");
        System.out.println("Driving a sedan : " + this);
    }
}
