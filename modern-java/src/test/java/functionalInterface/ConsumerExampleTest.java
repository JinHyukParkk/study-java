package functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

class ConsumerExampleTest {

    // Consumer<T>는 T 타입의 객체를 인자로 받고 리턴 값은 없다.

    @Test
    void test() {
        Consumer<String> printString = text -> System.out.println("Miss " + text + "?");
        printString.accept("me");
    }

    @Test
    void andThen() {
        Consumer<String> printString = text -> System.out.println("Miss " + text + "?");
        Consumer<String> printString2 = text -> System.out.println("--> Yes");

        printString.andThen(printString2).accept("me");
    }

    @Test
    void foreachTest() throws Exception {
        List<String> list = Arrays.asList("a", "b", "c");

        Consumer<String> consumer = text -> System.out.println(text);
        Consumer<String> printSep = text -> System.out.println("-------");

        list.forEach(consumer
                .andThen(printSep));
    }

    @Test
    void foreachExceptionTest() throws Exception {
        List<String> list = Arrays.asList("a", "b", "c");

        Consumer<String> consumer = text -> System.out.println(text);
        Consumer<String> throwException = text -> {
            try {
                throw new RuntimeException(text);
            } catch (Exception e) {
                throw e;
            }
        };

        try {
            list.forEach(consumer
                    .andThen(throwException));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void foreachNullTest() throws Exception {
        List<String> list = Arrays.asList("a", "b", "c");

        Consumer<String> consumer = text -> System.out.println(text);
        Consumer<String> nullConsumer = null;

        try {
            list.forEach(consumer
                    .andThen(nullConsumer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
