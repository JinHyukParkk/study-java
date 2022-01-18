package apple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BasicFilterAppleTest {

    private static List<Apple> appleList = new ArrayList<>();

    @BeforeAll
    static void settingData() {
        appleList.add(new Apple(Color.GREEN, 120));
        appleList.add(new Apple(Color.GREEN, 170));
        appleList.add(new Apple(Color.BLUE, 100));
        appleList.add(new Apple(Color.BLUE, 170));
        appleList.add(new Apple(Color.RED, 110));
        appleList.add(new Apple(Color.RED, 180));
        appleList.add(new Apple(Color.YELLO, 130));
        appleList.add(new Apple(Color.YELLO, 190));
    }

    @Test
    void greenFilterAppleTest() {
        List<Apple> result = BasicFilterApple.filterGreenApples(appleList);

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }
    }

    @Test
    void filterApplesByColorTest() {
        List<Apple> result = BasicFilterApple.filterApplesByColor(appleList, Color.RED);

        result.forEach(apple ->
            System.out.println(apple.getColor() + " / " + apple.getWeight())
        );
    }

    @Test
    void heavyFilterAppleTest() {
        List<Apple> result = BasicFilterApple.filterHeavyApples(appleList);

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }
    }
}
