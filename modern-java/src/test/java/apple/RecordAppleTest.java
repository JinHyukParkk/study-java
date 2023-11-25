package apple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordAppleTest {

    @Test
    void test() {
        RecordApple apple = new RecordApple(Color.RED, 100);

        System.out.println("기존 값 : " + apple);
    }
}
