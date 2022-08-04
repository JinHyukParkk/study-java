package stream.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Person {
    private String name;
    private int age;
    private String phoneNumber;

    @Builder
    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
