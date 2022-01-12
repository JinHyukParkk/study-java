package apple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasicFilterAppleTest {

    private static List<Apple> appleList = new ArrayList<>();

    @BeforeAll
    static void settingData() {
        appleList.add(new Apple("green", 120));
        appleList.add(new Apple("green", 170));
        appleList.add(new Apple("blue", 100));
        appleList.add(new Apple("blue", 170));
        appleList.add(new Apple("red", 110));
        appleList.add(new Apple("red", 180));
        appleList.add(new Apple("yello", 130));
        appleList.add(new Apple("yello", 190));
    }

    @Test
    void greenFilterAppleTest() {
        List<Apple> result = BasicFilterApple.filterGreenApples(appleList);

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }
    }

    @Test
    void heavyFilterAppleTest() {
        List<Apple> result = BasicFilterApple.filterHeavyApples(appleList);

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }
    }
}
