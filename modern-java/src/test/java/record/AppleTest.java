package record;

import org.junit.jupiter.api.Test;

class AppleTest {

    @Test
    void test() {
        Apple apple = new Apple(Color.RED, 100);
        System.out.println("기존 값 : " + apple);
        changeReference(apple);
        System.out.println("changeReference 후 변경 값 : " + apple);
        modifyReference(apple);
        System.out.println("modifyReference 후 변경 값 : " + apple);
    }

    private void changeReference(Apple apple) {
        Apple apple1 = new Apple(Color.GREEN, 200);
        apple = apple1;
        System.out.println("새로운 주소 값 : " + apple);
    }

    private void modifyReference(Apple apple) {
        apple.setColor(Color.BLUE);
    }
}
