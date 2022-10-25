package apple;

import static apple.Color.BLUE;
import static apple.Color.GREEN;
import static apple.Color.RED;

import org.junit.jupiter.api.Test;

class AppleTest {

    @Test
    void test() {
        Apple apple = new Apple(RED, 100);
        System.out.println("기존 값 : " + apple);
        changeReference(apple);
        System.out.println("changeReference 후 변경 값 : " + apple);
        modifyReference(apple);
        System.out.println("modifyReference 후 변경 값 : " + apple);
    }

    private void changeReference(Apple apple) {
        Apple apple1 = new Apple(GREEN, 200);
        apple = apple1;
        System.out.println("새로운 주소 값 : " + apple);
    }

    private void modifyReference(Apple apple) {
        apple.setColor(BLUE);
    }
}
