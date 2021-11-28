package apple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterAppleTest {

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
        List<Apple> result = FilterApple.filterApples(appleList, FilterApple::isGreenApple);

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }

    }

    @Test
    void heavyFilterAppleTest() {
        List<Apple> result = FilterApple.filterApples(appleList, FilterApple::isHeavyApple);

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }
    }

    @Test
    void greenFilterAppleLamdaTest() {
        List<Apple> result = FilterApple.filterApples(appleList, (Apple a) -> "green".equals(a.getColor()));

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }

    }

    @Test
    void heavyFilterAppleLamdaTest() {
        List<Apple> result = FilterApple.filterApples(appleList, (Apple a) -> a.getWeight() > 150);

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }
    }
}