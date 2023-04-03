package org.example.reference;

import org.example.models.Car;
import org.example.models.Sedan;
import org.example.models.Suv;
import org.example.models.User;
import org.example.models.Van;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

class ConstructReferenceExampleTest {

    @Test
    void case1() {
        BiFunction<Integer, String, User> userCreator = User::new;
        User hyuk = userCreator.apply(1, "hyuk");
        System.out.println(hyuk);
    }

    @Test
    @DisplayName("Map을 이용한 ConstructReference 응용")
    void case2() {
        String[][] inputs = new String[][]{
            {"sedan", "Sonata", "Hyundai"},
            {"van", "Sienna", "Toyota"},
            {"sedan", "Model S", "Tesla"},
            {"suv", "Sorento", "KIA"}
        };

        List<Car> cars = new ArrayList<>();

        Map<String, BiFunction<String, String, Car>> carTypeToConstructor = new HashMap<>();
        carTypeToConstructor.put("sedan", Sedan::new);
        carTypeToConstructor.put("suv", Suv::new);
        carTypeToConstructor.put("van", Van::new);

        for (String[] input : inputs) {
            cars.add(carTypeToConstructor.get(input[0]).apply(input[1], input[2]));
        }

        cars.forEach(Car::drive);
    }
}
