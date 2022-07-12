package figure;

import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test
    void test() {
        Figure rectangle = new Rectangle(3, 4);
        System.out.println(rectangle.area());
        rectangle.print();
    }
}
