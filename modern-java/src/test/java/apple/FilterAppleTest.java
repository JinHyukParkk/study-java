package apple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FilterAppleTest {

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
        appleList.add(new Apple(Color.GREEN, 230));
        appleList.add(new Apple(Color.RED, 100));
        appleList.add(new Apple(Color.BLUE, 600));
        appleList.add(new Apple(Color.RED, 80));
        appleList.add(new Apple(Color.GREEN, 330));
        appleList.add(new Apple(Color.RED, 500));
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
        List<Apple> result = FilterApple.filterApples(appleList, (Apple apple) -> Color.GREEN.equals(apple.getColor()));

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }
    }

    @Test
    void redFilterAppleLamdaTest() {
        List<Apple> result = FilterApple.filterApples(appleList, (Apple apple) -> Color.RED.equals(apple.getColor()));

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }
    }

    @Test
    void heavyFilterAppleLamdaTest() {
        List<Apple> result = FilterApple.filterApples(appleList, (Apple apple) -> apple.getWeight() > 150);

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }
    }

    @Test
    void bigHeavyFilterAppleLamdaTest() {
        List<Apple> result = FilterApple.filterApples(appleList, (Apple apple) -> apple.getWeight() > 200);

        for (Apple apple : result) {
            System.out.println(apple.getColor() + " / " + apple.getWeight());
        }
    }
}
