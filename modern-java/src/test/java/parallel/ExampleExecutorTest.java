package parallel;

import org.junit.jupiter.api.Test;

class ExampleExecutorTest {

    @Test
    void test() throws InterruptedException {
        new ExampleExecutor().execute();
    }
}
