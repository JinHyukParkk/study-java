package record;

import org.junit.jupiter.api.Test;

class RecordAppleTest {

    @Test
    void test() {
        RecordApple apple = new RecordApple(Color.RED, 100);

        System.out.println("기존 값 : " + apple);
    }
}
