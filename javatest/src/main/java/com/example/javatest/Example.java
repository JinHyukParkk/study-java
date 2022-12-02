package com.example.javatest;

public class Example {

    private ExampleType exampleType;

    private int limit;

    public Example(ExampleType exampleType, int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야한다.");
        }
        this.exampleType = exampleType;
        this.limit = limit;
    }

    public ExampleType getExampleType() {
        return exampleType;
    }

    public int getLimit() {
        return limit;
    }
}
